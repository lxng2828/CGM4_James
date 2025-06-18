package com.example.app.controller;

import com.example.app.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("e", new Employee());
        return "create";
    }

    @PostMapping("/createE")
    public String submit(@ModelAttribute("e") Employee e, Model model) {
        model.addAttribute("e", new Employee(e.getId(), e.getName(), e.getContactNumber()));
        return "info";
    }
}
