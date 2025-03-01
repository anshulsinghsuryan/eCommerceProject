package com.ecommerce.ProductService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String description;
    private String name;
    private double price;
    private String category;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;  // Each product is linked to a seller
}
