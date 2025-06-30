package com.codegym.session_cookie.controller;

import com.codegym.session_cookie.model.Product;
import com.codegym.session_cookie.service.CartService;
import com.codegym.session_cookie.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "cart-view";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId) {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            cartService.addProduct(product.get());
        }
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity) {
        cartService.updateProduct(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable("productId") Long productId) {
        cartService.removeProduct(productId);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}