package com.codegym.customer_province_management.formatter;

import java.text.ParseException;
import java.util.Locale;

import java.util.Optional;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.codegym.customer_province_management.Service.IProvinceService;
import com.codegym.customer_province_management.model.Province;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private IProvinceService iProvinceService;

    public ProvinceFormatter(IProvinceService iProvinceService) {
        this.iProvinceService = iProvinceService;
    }

    @Override
    public String print(Province province, Locale locale) {
        return province.toString();
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> provinceOptional = iProvinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

}
