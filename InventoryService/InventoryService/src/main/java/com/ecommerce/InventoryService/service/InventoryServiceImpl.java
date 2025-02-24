package com.ecommerce.InventoryService.service;

import com.ecommerce.InventoryService.entity.Inventory;
import com.ecommerce.InventoryService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{

        @Autowired
        private InventoryRepository inventoryRepository;

        @Override
        public boolean isInStock(String productId) {
            Optional<Inventory> inventory = inventoryRepository.findByProductId(productId);
            return inventory.isPresent() && inventory.get().getQuantity() > 0;
        }

        @Override
        public List<Inventory> getAllInventory() {
            return inventoryRepository.findAll();
        }

        @Override
        public void addStock(Inventory inventory) {
            inventoryRepository.save(inventory);
        }

        @Override
        public void updateStock(String productId, int quantity) {
            Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(productId);
            if (inventoryOptional.isPresent()) {
                Inventory inventory = inventoryOptional.get();
                inventory.setQuantity(quantity);
                inventoryRepository.save(inventory);
            } else {
                throw new RuntimeException("Product not found in inventory");
            }
        }
}
