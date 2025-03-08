package com.ecommerce.ProductService.model;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponse {
    private Long orderId ;
    private String status;
    private List<OrderItemResponse> orderItemResponseList;
}

