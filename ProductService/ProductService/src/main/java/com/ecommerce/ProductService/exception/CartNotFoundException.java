package com.ecommerce.ProductService.exception;

public class CartNotFoundException extends  RuntimeException{

    public CartNotFoundException(String message){
        super(message);
    }
}
