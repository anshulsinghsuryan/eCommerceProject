package com.ecommerce.orderService.models;

import lombok.Builder;

@Builder
public class OrderResponse {
    private Long orderId ;
    private String status;
}
