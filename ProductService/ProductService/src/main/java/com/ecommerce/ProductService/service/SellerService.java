package com.ecommerce.product.service;

import com.ecommerce.ProductService.entity.Seller;
import com.ecommerce.ProductService.exception.SellerAlreadyExistsException;

import com.ecommerce.ProductService.exception.SellerNotFoundException;
import com.ecommerce.ProductService.model.SellerRequestDTO;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();
    Seller getSellerById(String email) throws SellerNotFoundException;
    void addSeller(SellerRequestDTO seller) throws SellerAlreadyExistsException;
    void updateSeller(String email, Seller seller) throws SellerNotFoundException;
    void deleteSeller(String email) throws SellerNotFoundException;
}
