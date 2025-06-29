package com.codegym.session_cookie.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        Integer viewCount = (Integer) session.getAttribute("viewCount");

        if (viewCount == null) {
            viewCount = 1;
        } else {
            viewCount++;
        }

        session.setAttribute("viewCount", viewCount);
        model.addAttribute("sessionCount", viewCount);
        return "index";
    }
}