package com.ecommerce.ProductService.controller;

import com.ecommerce.ProductService.entity.Seller;
import com.ecommerce.product.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping("/add")
    public String addSeller(@RequestBody Seller seller) {
        sellerService.addSeller(seller);
        return "Seller added successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        sellerService.updateSeller(id, seller);
        return "Seller updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return "Seller deleted successfully!";
    }
}
