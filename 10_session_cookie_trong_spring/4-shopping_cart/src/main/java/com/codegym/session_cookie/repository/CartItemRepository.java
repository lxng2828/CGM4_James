package com.codegym.session_cookie.repository;

import com.codegym.session_cookie.model.Cart;
import com.codegym.session_cookie.model.CartItem;
import com.codegym.session_cookie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
}