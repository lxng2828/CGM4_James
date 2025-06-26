package com.example.app.controller;

import com.example.app.model.Customer;
import com.example.app.model.Province;
import com.example.app.service.CustomerService;
import com.example.app.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ProvinceService provinceService;

    @Autowired
    public CustomerController(CustomerService customerService, ProvinceService provinceService) {
        this.customerService = customerService;
        this.provinceService = provinceService;
    }

    @GetMapping
    public String listCustomers(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("provinces", provinceService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("provinces", provinceService.findAll());
            return "customer/edit";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/delete";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.removeCustomer(customer.getId());
        return "redirect:/customers";
    }

    @GetMapping("/province/{provinceId}")
    public String listCustomersByProvince(@PathVariable Long provinceId, Model model) {
        Province province = provinceService.findById(provinceId);
        if (province == null) {
            return "error/404";
        }
        List<Customer> customers = customerService.findAllByProvince(province);
        model.addAttribute("customers", customers);
        model.addAttribute("currentProvince", province);
        return "customer/listByProvince";
    }
}