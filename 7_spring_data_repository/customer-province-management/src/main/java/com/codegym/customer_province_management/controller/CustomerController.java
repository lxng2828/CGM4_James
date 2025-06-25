package com.codegym.customer_province_management.controller;

import com.codegym.customer_province_management.Service.ICustomerService;
import com.codegym.customer_province_management.Service.IProvinceService;
import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService customerService;
    private final IProvinceService provinceService;

    // Sử dụng constructor injection để đưa các dependency vào
    @Autowired
    public CustomerController(ICustomerService customerService, IProvinceService provinceService) {
        this.customerService = customerService;
        this.provinceService = provinceService;
    }

    // Cung cấp danh sách các tỉnh cho tất cả các view trong controller này
    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    // Hiển thị danh sách khách hàng
    @GetMapping
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    // Hiển thị form tạo mới khách hàng
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("message", "Tạo mới Khách hàng");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    // Xử lý yêu cầu tạo mới khách hàng
    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Tạo mới khách hàng thành công!");
        return modelAndView;
    }

    // Hiển thị form chỉnh sửa thông tin khách hàng
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    // Xử lý yêu cầu cập nhật thông tin khách hàng
    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Cập nhật thông tin khách hàng thành công!");
        return modelAndView;
    }

    // Hiển thị form xác nhận xóa khách hàng
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    // Xử lý yêu cầu xóa khách hàng
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }
}