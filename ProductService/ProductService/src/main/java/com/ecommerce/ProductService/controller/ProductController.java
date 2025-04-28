package com.ecommerce.ProductService.controller;


import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all products", description = "Fetches all the products available in the store")
    @ApiResponse(responseCode = "200", description = "Successfully fetched all products")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product by ID", description = "Fetches a product by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully fetched product details")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping("/{id}")
    public Product getProductById(@Parameter(description = "ID of the product to be fetched") @PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Add a new product", description = "Adds a new product to the inventory")
    @ApiResponse(responseCode = "201", description = "Product added successfully")
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully!";
    }

    @Operation(summary = "Update product details", description = "Updates the product details by product ID")
    @ApiResponse(responseCode = "200", description = "Product updated successfully")
    @PutMapping("/update/{id}")
    public String updateProduct(@Parameter(description = "ID of the product to be updated") @PathVariable Long id,
                                @RequestBody Product product) {
        productService.updateProduct(id, product);
        return "Product updated successfully!";
    }

    @Operation(summary = "Delete product", description = "Deletes a product by its ID")
    @ApiResponse(responseCode = "200", description = "Product deleted successfully")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@Parameter(description = "ID of the product to be deleted") @PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }
}