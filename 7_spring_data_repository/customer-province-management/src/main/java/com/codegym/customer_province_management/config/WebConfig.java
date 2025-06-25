package com.codegym.customer_province_management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.codegym.customer_province_management.formatter.ProvinceFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ProvinceFormatter provinceFormatter;

    public WebConfig(ProvinceFormatter provinceFormatter) {
        this.provinceFormatter = provinceFormatter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(provinceFormatter);
    }
}
