package com.codegym.aop_exception_handling.controller;

import com.codegym.aop_exception_handling.model.Customer;
import com.codegym.aop_exception_handling.service.ICustomerService;
import com.codegym.aop_exception_handling.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer created successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found with ID: " + id);
        }
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer deletedCustomer = customerService.delete(id);
        if (deletedCustomer == null) {
            throw new ResourceNotFoundException("Customer to delete not found with ID: " + id);
        }
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/details/{id}")
    public ModelAndView customerDetails(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found with ID: " + id);
        }
        ModelAndView modelAndView = new ModelAndView("customer/details");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
