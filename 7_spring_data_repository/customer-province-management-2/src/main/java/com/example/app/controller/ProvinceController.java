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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {

    private final ProvinceService provinceService;
    private final CustomerService customerService;

    @Autowired
    public ProvinceController(ProvinceService provinceService, CustomerService customerService) {
        this.provinceService = provinceService;
        this.customerService = customerService;
    }

    @GetMapping
    public String listProvinces(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Province> provinces = provinceService.findAll(pageable);
        model.addAttribute("provinces", provinces);
        return "province/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("province", new Province());
        model.addAttribute("message", "Thêm tỉnh mới");
        return "province/create-edit";
    }

    @PostMapping("/create")
    public String createProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.createProvince(province);
        redirectAttributes.addFlashAttribute("message", "Tạo mới tỉnh thành công!");
        return "redirect:/provinces";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Province province = provinceService.findById(id);
        if (province != null) {
            model.addAttribute("province", province);
            model.addAttribute("message", "Chỉnh sửa tỉnh");
            return "province/create-edit";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/edit")
    public String updateProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.createProvince(province);
        redirectAttributes.addFlashAttribute("message", "Cập nhật tỉnh thành công!");
        return "redirect:/provinces";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Province province = provinceService.findById(id);
        if (province != null) {
            model.addAttribute("province", province);
            return "province/delete";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/delete")
    public String deleteProvince(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        provinceService.removeProvince(id);
        redirectAttributes.addFlashAttribute("message", "Xóa tỉnh thành công!");
        return "redirect:/provinces";
    }

    @GetMapping("/view/{id}")
    public String viewProvince(@PathVariable("id") Long id, Model model) {
        Province province = provinceService.findById(id);
        if (province == null) {
            return "error/404";
        }

        List<Customer> customers = customerService.findAllByProvince(province);
        model.addAttribute("province", province);
        model.addAttribute("customers", customers);
        return "province/view";
    }
}