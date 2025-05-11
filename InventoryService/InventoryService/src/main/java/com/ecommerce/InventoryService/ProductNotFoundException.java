package com.ecommerce.InventoryService;

public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }
}
