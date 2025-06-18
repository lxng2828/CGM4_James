package com.codegym.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.codegym.customer_management.model.User;
import com.codegym.customer_management.service.CustomerService;

@Controller
public class UserController {

    private final CustomerService customerService;

    @Autowired
    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String showCustomerList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer-list";
    }

    @GetMapping("/show-form")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        customerService.save(user);
        return "redirect:/";
    }
}