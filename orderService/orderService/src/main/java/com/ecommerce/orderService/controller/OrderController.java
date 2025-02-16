package com.ecommerce.orderService.controller;

import com.ecommerce.orderService.models.OrderDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{id}")
    private void getOrderDetailsById(@PathVariable String id){

    }

    @GetMapping("/{user}")
    private void getOrderDetailsByUser(@PathVariable String id){

    }

    @PostMapping
    private void addOrderDetails(@RequestBody OrderDetails orderDetails){

    }

    @PutMapping("/{orderID}/{status}")
    private void updateOrderDetailsStatus(@PathVariable("orderId") String orderId, @PathVariable("status") String status){

    }
}
