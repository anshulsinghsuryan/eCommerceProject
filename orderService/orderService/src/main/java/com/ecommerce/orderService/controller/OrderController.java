package com.ecommerce.orderService.controller;

import com.ecommerce.orderService.models.OrderDetails;
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
    public OrderDetails getOrderDetailsById(@PathVariable Long id){
        return orderDetailsService.getOrderDetailsById(id);
    }

    @GetMapping("/{userId}")
    public List<OrderDetails> getOrderDetailsByUser(@PathVariable Long userId){
        return orderDetailsService.getOrderDetailsByUser(userId);
    }

    @PostMapping
    public  String addOrderDetails(@RequestBody OrderDetails orderDetails){
        orderDetailsService.addOrderDetails(orderDetails);
        return "Details added successfully";
    }

    @PutMapping("/{orderID}/{status}")
    public String updateOrderDetailsStatus(@PathVariable("orderId") Long orderId, @PathVariable("status") String status){
        orderDetailsService.updateOrderDetailsStatus(orderId,status);
        return "Details updated Successfully";
    }
}
