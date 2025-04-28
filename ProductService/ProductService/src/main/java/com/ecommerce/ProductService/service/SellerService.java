package com.ecommerce.product.service;

import com.ecommerce.ProductService.entity.Seller;
import com.ecommerce.ProductService.exception.SellerAlreadyExistsException;

import com.ecommerce.ProductService.model.SellerRequestDTO;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();
    Seller getSellerById(Long id);
    void addSeller(SellerRequestDTO seller) throws SellerAlreadyExistsException;
    void updateSeller(Long id, Seller seller);
    void deleteSeller(Long id);
}
