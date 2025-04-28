package com.ecommerce.ProductService.exception;


import com.ecommerce.ProductService.model.SellerExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExpectionHandler {


    @ExceptionHandler(SellerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SellerExceptionDTO sellerAlreadyExist(SellerAlreadyExistsException  exception){
        return SellerExceptionDTO.builder().message(exception.getMessage()).httpStatusCode(HttpStatus.BAD_REQUEST).build();
    }


}
