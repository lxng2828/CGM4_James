package com.codegym.customer_province_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getMethodName() {
        return new String("home_page");
    }

}
