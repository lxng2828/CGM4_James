package com.codegym.customer_province_management.Service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegym.customer_province_management.Service.IProvinceService;
import com.codegym.customer_province_management.model.Province;
import com.codegym.customer_province_management.repository.IProvinceRepository;

@Service
public class ProvinceService implements IProvinceService {

    private IProvinceRepository iProvinceRepository;

    public ProvinceService(IProvinceRepository iProvinceRepository) {
        this.iProvinceRepository = iProvinceRepository;
    }

    @Override
    public Iterable findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {

        return iProvinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

}
