package com.ecommerce.ProductService.model;

import lombok.Builder;

@Builder
public class OrderResponse {
    private Long orderId ;
    private String status;
}

