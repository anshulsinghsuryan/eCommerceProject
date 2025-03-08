package com.ecommerce.orderService.models;

import lombok.Builder;

import java.util.List;

@Builder
public class OrderResponse {
    private Long orderId ;
    private List<OrderItemResponse> orderItemResponseList;
    private String status;
}
