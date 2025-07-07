package com.codegym.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping({ "/", "/home" })
    public String home() {
        return "home";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client-page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/db")
    public String dbPage() {
        return "db-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}