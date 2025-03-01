package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.Seller;
import com.ecommerce.ProductService.repository.SellerRepository;
import com.ecommerce.product.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found with id: " + id));
    }

    @Override
    public void addSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Override
    public void updateSeller(Long id, Seller seller) {
        Optional<Seller> existingSeller = sellerRepository.findById(id);
        if (existingSeller.isPresent()) {
            Seller updatedSeller = existingSeller.get();
            updatedSeller.setSellerName(seller.getSellerName());
            updatedSeller.setEmail(seller.getEmail());
            updatedSeller.setPhone(seller.getPhone());
            sellerRepository.save(updatedSeller);
        } else {
            throw new RuntimeException("Seller not found with id: " + id);
        }
    }

    @Override
    public void deleteSeller(Long id) {
        if (sellerRepository.existsById(id)) {
            sellerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Seller not found with id: " + id);
        }
    }
}
