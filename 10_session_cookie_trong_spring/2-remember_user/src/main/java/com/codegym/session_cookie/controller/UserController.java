package com.codegym.session_cookie.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private static final String USERNAME_COOKIE = "rememberedUsername";
    private static final int COOKIE_MAX_AGE_SECONDS = 7 * 24 * 60 * 60;

    @GetMapping("/")
    public String showLoginForm(@CookieValue(name = USERNAME_COOKIE, required = false) String rememberedUsername,
            Model model) {
        if (rememberedUsername != null && !rememberedUsername.isEmpty()) {
            model.addAttribute("username", rememberedUsername);
            model.addAttribute("rememberMe", true);
        } else {
            model.addAttribute("username", "");
            model.addAttribute("rememberMe", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
            @RequestParam String password,
            @RequestParam(required = false) boolean rememberMe,
            HttpServletResponse response,
            Model model) {

        if ("long".equals(username) && "123".equals(password)) {

            if (rememberMe) {
                Cookie cookie = new Cookie(USERNAME_COOKIE, username);
                cookie.setMaxAge(COOKIE_MAX_AGE_SECONDS);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                // cookie.setSecure(true);
                response.addCookie(cookie);
                System.out.println("Cookie '" + USERNAME_COOKIE + "' đã được tạo/cập nhật với giá trị: " + username);
            } else {
                Cookie cookie = new Cookie(USERNAME_COOKIE, null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                System.out.println("Cookie '" + USERNAME_COOKIE + "' đã được xóa.");
            }

            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng!");
            model.addAttribute("username", username);
            model.addAttribute("rememberMe", rememberMe);
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(USERNAME_COOKIE, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        System.out.println("Người dùng đã đăng xuất. Cookie '" + USERNAME_COOKIE + "' đã được xóa.");
        return "redirect:/";
    }
}