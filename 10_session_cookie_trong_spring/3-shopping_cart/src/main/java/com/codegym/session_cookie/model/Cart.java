package com.codegym.session_cookie.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        CartItem item = items.get(product.getId());
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem(product, quantity);
            items.put(product.getId(), item);
        }
    }

    public void updateItem(int productId, int quantity) {
        CartItem item = items.get(productId);
        if (item != null) {
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                items.remove(productId);
            }
        }
    }

    public void removeItem(int productId) {
        items.remove(productId);
    }

    public void clear() {
        items.clear();
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }
}