package com.ecommerce.ProductService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORYSERVICE")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    Boolean isProductInStock(@PathVariable("id") String productId);
}
