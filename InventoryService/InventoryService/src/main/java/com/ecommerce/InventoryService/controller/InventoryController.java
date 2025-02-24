package com.ecommerce.InventoryService.controller;


import com.ecommerce.InventoryService.entity.Inventory;
import com.ecommerce.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public boolean isProductInStock(@PathVariable String productId) {
        return inventoryService.isInStock(productId);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping("/add")
    public String addStock(@RequestBody Inventory inventory) {
        inventoryService.addStock(inventory);
        return "Stock added successfully!";
    }

    @PutMapping("/update/{productId}/{quantity}")
    public String updateStock(@PathVariable String productId, @PathVariable int quantity) {
        inventoryService.updateStock(productId, quantity);
        return "Stock updated successfully!";
    }
}
