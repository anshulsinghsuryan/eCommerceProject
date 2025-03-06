package com.ecommerce.InventoryService.service;

import com.ecommerce.InventoryService.entity.Inventory;
import com.ecommerce.InventoryService.model.InventoryResponse;

import java.util.List;

public interface InventoryService {
    boolean isInStock(String productId);
    List<Inventory> getAllInventory();
    void addStock(Inventory inventory);
    void updateStock(String productId, int quantity);

    InventoryResponse decreaseStock(String productId);
}
