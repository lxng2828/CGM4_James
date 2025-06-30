package com.codegym.session_cookie.service;

import com.codegym.session_cookie.model.CartItem;
import com.codegym.session_cookie.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartService {
    private final Map<Long, CartItem> cartItems = new HashMap<>();

    public void addProduct(Product product) {
        CartItem item = cartItems.get(product.getId());
        if (item == null) {
            cartItems.put(product.getId(), new CartItem(product, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void updateProduct(Long productId, int quantity) {
        CartItem item = cartItems.get(productId);
        if (item != null) {
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                cartItems.remove(productId);
            }
        }
    }

    public void removeProduct(Long productId) {
        cartItems.remove(productId);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public Collection<CartItem> getCartItems() {
        return cartItems.values();
    }

    public double getTotalAmount() {
        return cartItems.values().stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }
}