package com.ecommerce.orderService.service;

import com.ecommerce.orderService.client.InventoryClient;
import com.ecommerce.orderService.entity.OrderDetails;
import com.ecommerce.orderService.entity.OrderItem;
import com.ecommerce.orderService.models.CommonEnum;
import com.ecommerce.orderService.models.InventoryResponse;
import com.ecommerce.orderService.models.OrderItemResponse;
import com.ecommerce.orderService.models.OrderResponse;
import com.ecommerce.orderService.repository.OrderDetailsRepository;
import com.ecommerce.orderService.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @Transactional
    @Override
    public OrderResponse addOrderDetails(OrderDetails orderDetails) {
        List<OrderItem> listInventoryResponse = new ArrayList<>();
        orderDetails.getOrderItems().forEach(orderItem -> {
            InventoryResponse inventoryResponse= inventoryClient.decreaseStock(orderItem.getProductID());
            if(inventoryResponse.getMessage().equals(CommonEnum.In_Stock.name())){
                listInventoryResponse.add(orderItem);
            }
        });
        listInventoryResponse.forEach(item -> item.setOrderDetails(orderDetails));
        orderDetails.setOrderItems(listInventoryResponse);
        OrderDetails orderDetail = orderDetailsRepository.save(orderDetails);
        return OrderResponse.builder()
                .orderId(orderDetail.getOrderId())
                .orderItemResponseList(orderDetail.getOrderItems().stream().map(orderItem -> {
                    OrderItemResponse orderItemResponse = new OrderItemResponse();
                    orderItemResponse.setProductId(orderItem.getProductID());
                    orderItemResponse.setProductName(orderItem.getProductName());
                    orderItemResponse.setStatus(CommonEnum.Created.name());
                    return orderItemResponse;
                }).collect(Collectors.toList()))
                .status(CommonEnum.Created.name())
                .build();
    }

    @Override
    public OrderDetails getOrderDetailsById(Long id) {
        return orderDetailsRepository.findById(id).orElseThrow( () -> new RuntimeException("Id not found -> " +id));
    }

    @Override
    public List<OrderDetails> getOrderDetailsByUser(Long userId) {
        return orderDetailsRepository.getOrderDetailsByUserId(userId);
    }

    @Override
    public void updateOrderDetailsStatus(Long id, String orderStatus) {
        OrderItem orderItem = orderItemRepository.findById(id).orElse(null);
        orderItem.setStatus(orderStatus);
        orderItemRepository.save(orderItem);
    }
}
