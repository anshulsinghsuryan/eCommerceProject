package com.ecommerce.orderService.controller;

import com.ecommerce.orderService.entity.OrderDetails;

import com.ecommerce.orderService.models.OrderResponse;
import com.ecommerce.orderService.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/{id}")
    public OrderDetails getOrderDetailsById(@PathVariable("id") Long id){
        return orderDetailsService.getOrderDetailsById(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDetails> getOrderDetailsByUser(@PathVariable("userId") Long userId){
        return orderDetailsService.getOrderDetailsByUser(userId);
    }

    @PostMapping
    public OrderResponse addOrderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.addOrderDetails(orderDetails);
    }

    @PutMapping("/{orderId}/{status}")
    public String updateOrderDetailsStatus(@PathVariable("orderId") Long orderId, @PathVariable("status") String status){
        orderDetailsService.updateOrderDetailsStatus(orderId,status);
        return "Details updated Successfully";
    }
}
