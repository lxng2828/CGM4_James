package com.codegym.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codegym.validation.model.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/")
    public String getRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }

    @PostMapping("/register")
    public String handleRegisterForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register_form";
        }

        String message = "Da dang ky thanh cong cho nguoi dung" + user;
        model.addAttribute("message", message);
        model.addAttribute("user", user);
        return "register_form";
    }
}
