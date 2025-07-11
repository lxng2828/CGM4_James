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
@RequestMapping("/provinces")
public class ProvinceController {

    private final IProvinceService provinceService;
    private final ICustomerService customerService;

    // Sử dụng constructor injection
    @Autowired
    public ProvinceController(IProvinceService provinceService, ICustomerService customerService) {
        this.provinceService = provinceService;
        this.customerService = customerService;
    }

    // Hiển thị danh sách các tỉnh
    @GetMapping
    public ModelAndView listProvinces() {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    // Hiển thị form tạo mới tỉnh
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    // Xử lý yêu cầu tạo mới tỉnh
    @PostMapping("/create")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "Tạo mới tỉnh thành công!");
        return modelAndView;
    }

    // Hiển thị form chỉnh sửa tỉnh
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    // Xử lý yêu cầu cập nhật tỉnh
    @PostMapping("/edit")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Cập nhật tỉnh thành công!");
        return modelAndView;
    }

    // Hiển thị form xác nhận xóa tỉnh
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    // Xử lý yêu cầu xóa tỉnh
    @PostMapping("/delete")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:/provinces";
    }

    // Xem chi tiết một tỉnh và danh sách khách hàng thuộc tỉnh đó
    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        Optional<Province> provinceOptional = provinceService.findById(id);
        if (!provinceOptional.isPresent()) {
            return new ModelAndView("/error-404");
        }

        Province province = provinceOptional.get();
        Iterable<Customer> customers = customerService.findAllByProvice(province);

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}