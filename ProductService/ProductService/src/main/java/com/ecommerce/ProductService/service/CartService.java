package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.Cart;
import com.ecommerce.ProductService.entity.CartItem;
import com.ecommerce.ProductService.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(String userId, CartItem cartItem) {
        Optional<Cart> existingCart = cartRepository.findByUserId(userId);

        Cart cart = existingCart.orElseGet(() -> new Cart(null, userId, new ArrayList<>(), 0.0));

        cart.getItems().add(cartItem);
        cartItem.setCart(cart);

        cart.setTotalPrice(cart.getTotalPrice() + (cartItem.getPrice() * cartItem.getQuantity()));

        return cartRepository.save(cart);
    }

    public Cart getCartByUser(String userId) {
        return cartRepository.findByUserId(userId).orElse(null);
    }

    public void removeItem(String userId, Long itemId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().removeIf(item -> item.getId().equals(itemId));
        cartRepository.save(cart);
    }

    public void clearCart(String userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }
}
