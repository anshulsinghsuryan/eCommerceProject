package com.ecommerce.orderService.service;

import com.ecommerce.orderService.models.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDetailsService {

    void addOrderDetails(OrderDetails orderDetails);

    OrderDetails getOrderDetailsById(Long id);

    List<OrderDetails> getOrderDetailsByUser(Long userId);

    void updateOrderDetailsStatus(Long id, String orderStatus);
}
