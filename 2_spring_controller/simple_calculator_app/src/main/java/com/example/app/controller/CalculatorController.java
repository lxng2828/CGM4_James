package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculator() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("firstNumber") double firstNumber,
            @RequestParam("secondNumber") double secondNumber,
            @RequestParam("operator") String operator,
            Model model
    ) {
        double result = 0;
        String error = null;

        switch (operator) {
            case "Addition(+)":
                result = firstNumber + secondNumber;
                break;
            case "Subtraction(-)":
                result = firstNumber - secondNumber;
                break;
            case "Multiplication(X)":
                result = firstNumber * secondNumber;
                break;
            case "Division(/)":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    error = "Không thể thực hiện phép chia cho 0!";
                }
                break;
            default:
                error = "Phép toán không hợp lệ.";
        }

        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        if (error != null) {
            model.addAttribute("error", error);
        } else {
            model.addAttribute("result", result);
        }

        return "index";
    }
}