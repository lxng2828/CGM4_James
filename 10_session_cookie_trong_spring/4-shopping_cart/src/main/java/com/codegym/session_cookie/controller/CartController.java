package com.codegym.session_cookie.controller;

import com.codegym.session_cookie.model.Cart;
import com.codegym.session_cookie.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model, HttpSession session) {
        Cart cart = cartService.getCart(session);
        model.addAttribute("cartItems", cart.getItems());
        model.addAttribute("totalAmount", cart.getTotalAmount());
        return "cart-view";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId, HttpSession session) {
        cartService.addProduct(productId, session);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity,
            HttpSession session) {
        cartService.updateProduct(productId, quantity, session);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable("productId") Long productId, HttpSession session) {
        cartService.removeProduct(productId, session);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart(HttpSession session) {
        cartService.clearCart(session);
        return "redirect:/cart";
    }
}