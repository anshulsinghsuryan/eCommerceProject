package com.ecommerce.ProductService.controller;


import com.ecommerce.ProductService.entity.Cart;
import com.ecommerce.ProductService.entity.CartItem;
import com.ecommerce.ProductService.model.OrderResponse;
import com.ecommerce.ProductService.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{userId}")
    public Cart addToCart(@PathVariable String userId, @RequestBody CartItem cartItem) {
        return cartService.addToCart(userId, cartItem);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartService.getCartByUser(userId);
    }

    @GetMapping("/place/{userId}")
    public OrderResponse getOrderPlaced(@PathVariable String userId) {
        return cartService.getOrderPlacedCart(userId);
    }

    @DeleteMapping("/remove/{userId}/{itemId}")
    public String removeItem(@PathVariable String userId, @PathVariable Long itemId) {
        cartService.removeItem(userId, itemId);
        return "Item removed successfully!";
    }

    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        return "Cart cleared!";
    }
}
