package com.codegym.session_cookie.controller;

import com.codegym.session_cookie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }
}