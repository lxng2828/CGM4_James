package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("user", customerService.findById(id));
        return "user-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        customerService.save(user);
        return "redirect:/";
    }

    @GetMapping("/showinfo/{id}")
    public String showInformation(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "info";
    }
}
