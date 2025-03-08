package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.client.InventoryClient;
import com.ecommerce.ProductService.client.OrderClient;
import com.ecommerce.ProductService.entity.Cart;
import com.ecommerce.ProductService.entity.CartItem;
import com.ecommerce.ProductService.model.OrderDetails;
import com.ecommerce.ProductService.model.OrderItem;
import com.ecommerce.ProductService.model.OrderResponse;
import com.ecommerce.ProductService.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final OrderClient orderClient;
    private final InventoryClient inventoryClient;

    public Cart addToCart(String userId, CartItem cartItem) {
        Cart cart =  cartRepository.findByUserId(userId).orElse(null);

        assert cart != null;
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

    public OrderResponse getOrderPlacedCart(String userId) {
        Cart cart = getCartByUser(userId);
        OrderResponse orderResponse = new OrderResponse();
        cart.setItems(cart.getItems().stream().filter(item -> inventoryClient.isProductInStock(item.getProductId()))
                .map(item -> {
                    CartItem cartUpdated = new CartItem();
                    cartUpdated.setId(item.getId());
                    cartUpdated.setQuantity(item.getQuantity());
                    cartUpdated.setPrice(item.getPrice());
                    cartUpdated.setSellerId(item.getSellerId());
                    cartUpdated.setProductName(item.getProductName());
                    cartUpdated.setProductId(item.getProductId());
                    return cartUpdated;
        }).collect(Collectors.toList()));

        if(ObjectUtils.notEqual(cart, null)) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setUserId(cart.getUserId());
            orderDetails.setTotalAmount(cart.getTotalPrice());
            orderDetails.setOrderItems(cart.getItems().stream().map(item -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setAmount(item.getPrice());
                orderItem.setProductID(item.getProductId());
                orderItem.setProductName(item.getProductName());
                orderItem.setSellerID(item.getSellerId());
                orderItem.setQuantity(item.getQuantity());
                return orderItem;
            }).collect(Collectors.toList()));
            orderResponse =  orderClient.addOrderDetails(orderDetails);
        }

        cart.getItems().forEach(cartItem -> {
            removeItem(cart.getUserId(), cartItem.getId() );
        });

        return orderResponse;
    }
}
