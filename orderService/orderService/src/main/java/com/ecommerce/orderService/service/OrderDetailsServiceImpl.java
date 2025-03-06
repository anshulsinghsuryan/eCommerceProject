package com.ecommerce.orderService.service;

import com.ecommerce.orderService.entity.OrderDetails;
import com.ecommerce.orderService.entity.OrderItem;
import com.ecommerce.orderService.models.OrderResponse;
import com.ecommerce.orderService.repository.OrderDetailsRepository;
import com.ecommerce.orderService.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderResponse addOrderDetails(OrderDetails orderDetails) {
        OrderDetails orderDetail = orderDetailsRepository.save(orderDetails);
        return OrderResponse.builder().orderId(orderDetail.getOrderId()).status("Created").build();
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
