package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/time")
    public String getTimeByZone(
            ModelMap model,
            @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city
    ) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locate = TimeZone.getTimeZone(city);
        date = new Date(date.getTime() + (locate.getRawOffset() - local.getRawOffset()));
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "time";
    }
}
