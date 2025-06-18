package com.codegym.currency_converter_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/")
    public String showForm() {
        return "cf";
    }

    @PostMapping("/convert")
    public String conv(@RequestParam("rate") double rate, @RequestParam("usd") double usd, Model m) {
    double vnd = usd*rate;

    m.addAttribute("rate",rate);
    m.addAttribute("usd",usd);
    m.addAttribute("vnd",vnd);
    return "rs";
    }
}
