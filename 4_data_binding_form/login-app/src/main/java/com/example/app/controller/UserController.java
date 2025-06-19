package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.model.Login;
import com.example.app.model.User;
import com.example.app.service.UserSevevice;

@Controller
public class UserController {

    @Autowired
    private UserSevevice us;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model) {
        String account = login.getAccount();
        String password = login.getPassword();
        boolean isLogin = us.checkLogin(account, password);
        String message = "";
        if (isLogin) {
            User user = us.getUser(account);
            model.addAttribute("user", user);
            message = "Welcome, " + user.getName() + "!";
        } else {
            message = "account or password incorrect!";
        }
        model.addAttribute("message", message);
        return "result";
    }
}