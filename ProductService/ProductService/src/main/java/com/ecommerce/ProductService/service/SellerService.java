package com.ecommerce.product.service;

import com.ecommerce.ProductService.entity.Seller;
import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();
    Seller getSellerById(Long id);
    void addSeller(Seller seller);
    void updateSeller(Long id, Seller seller);
    void deleteSeller(Long id);
}
