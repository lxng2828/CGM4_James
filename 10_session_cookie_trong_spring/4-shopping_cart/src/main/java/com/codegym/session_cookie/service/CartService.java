package com.codegym.session_cookie.service;

import com.codegym.session_cookie.model.Cart;
import com.codegym.session_cookie.model.CartItem;
import com.codegym.session_cookie.model.Product;
import com.codegym.session_cookie.repository.CartItemRepository;
import com.codegym.session_cookie.repository.CartRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
            ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    public Cart getCart(HttpSession session) {
        String sessionId = session.getId();
        Optional<Cart> optionalCart = cartRepository.findBySessionId(sessionId);
        boolean cartExists = optionalCart.isPresent();
        if (cartExists) {
            Cart existingCart = optionalCart.get();
            return existingCart;
        } else {
            Cart newCart = new Cart();
            newCart.setSessionId(sessionId);
            Cart savedCart = cartRepository.save(newCart);
            return savedCart;
        }
    }

    public void addProduct(Long productId, HttpSession session) {
        Cart cart = getCart(session);
        Optional<Product> optionalProduct = productService.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }
        Product product = optionalProduct.get();
        Optional<CartItem> optionalItem = cartItemRepository.findByCartAndProduct(cart, product);
        if (optionalItem.isPresent()) {
            CartItem existingItem = optionalItem.get();
            int currentQuantity = existingItem.getQuantity();
            int updatedQuantity = currentQuantity + 1;
            existingItem.setQuantity(updatedQuantity);
            cartItemRepository.save(existingItem);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(1);
            cartItemRepository.save(newItem);
        }
    }

    public void updateProduct(Long productId, int quantity, HttpSession session) {
        Cart cart = getCart(session);
        Optional<Product> optionalProduct = productService.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }
        Product product = optionalProduct.get();
        Optional<CartItem> optionalCartItem = cartItemRepository.findByCartAndProduct(cart, product);
        if (!optionalCartItem.isPresent()) {
            throw new IllegalArgumentException("CartItem not found");
        }
        CartItem item = optionalCartItem.get();
        if (quantity > 0) {
            item.setQuantity(quantity);
            cartItemRepository.save(item);
        } else {
            cartItemRepository.delete(item);
        }
    }

    public void removeProduct(Long productId, HttpSession session) {
        Cart cart = getCart(session);
        Optional<Product> optionalProduct = productService.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }
        Product product = optionalProduct.get();
        Optional<CartItem> optionalItem = cartItemRepository.findByCartAndProduct(cart, product);
        if (optionalItem.isPresent()) {
            CartItem item = optionalItem.get();
            cartItemRepository.delete(item);
        }
    }

    public void clearCart(HttpSession session) {
        Cart cart = getCart(session);
        List<CartItem> currentItems = cart.getItems();
        currentItems.clear();
        cartRepository.save(cart);
    }

}