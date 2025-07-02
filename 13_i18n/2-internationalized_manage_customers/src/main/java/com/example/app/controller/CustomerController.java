package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.model.Customer;
import com.example.app.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer saved successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customers/form";
        }
        redirectAttributes.addFlashAttribute("errorMessage", "Customer not found!");
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id, RedirectAttributes redirectAttributes) {

        Customer customer = customerService.findById(id);
        if (customer != null) {
            customerService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Customer not found!");
        }
        return "redirect:/customers";
    }
}