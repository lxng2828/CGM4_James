package com.codegym.formregistervalidate.controller;

import com.codegym.formregistervalidate.model.User;
import com.codegym.formregistervalidate.service.impl.UserServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String submitForm(
            @ModelAttribute("user") @Valid User user,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        userService.save(user);

        model.addAttribute("user", user);
        return "result";
    }
}

