package com.ecommerce.orderService.service;

import com.ecommerce.orderService.entity.OrderDetails;
import com.ecommerce.orderService.models.OrderResponse;

import java.util.List;

public interface OrderDetailsService {

    OrderResponse addOrderDetails(OrderDetails orderDetails);

    OrderDetails getOrderDetailsById(Long id);

    List<OrderDetails> getOrderDetailsByUser(Long userId);

    void updateOrderDetailsStatus(Long id, String orderStatus);
}
