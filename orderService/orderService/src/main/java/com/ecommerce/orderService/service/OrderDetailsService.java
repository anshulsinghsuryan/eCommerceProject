package com.ecommerce.orderService.service;

import com.ecommerce.orderService.models.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {

    public void addOrderDetails(OrderDetails orderDetails);

    public OrderDetails getOrderDetailsById(Long id);

    public List<OrderDetails> getOrderDetailsByUser(Long userId);

    public void updateOrderDetailsStatus(Long id, String orderStatus);
}
