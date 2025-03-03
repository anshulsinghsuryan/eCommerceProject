package com.ecommerce.ProductService.controller;


import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // ✅ Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // ✅ Add a new product
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully!";
    }

    // ✅ Update product details
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return "Product updated successfully!";
    }

    // ✅ Delete a product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }
}
