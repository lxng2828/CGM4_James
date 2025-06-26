package com.example.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.app.model.Province;
import com.example.app.repository.ProvinceRepo;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService {
    private final ProvinceRepo provinceRepo;

    public ProvinceService(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    public List<Province> findAll() {
        List<Province> provinceList = provinceRepo.findAll();
        return provinceList;
    }

    public Page<Province> findAll(Pageable pageable) {
        return provinceRepo.findAll(pageable);
    }

    public Province findById(Long id) {
        Province province = provinceRepo.findById(id).orElse(null);
        return province;
    }

    public Province createProvince(Province province) {
        Province savedProvince = provinceRepo.save(province);
        return savedProvince;
    }

    public Province editProvince(Long id) {
        Province province = provinceRepo.findById(id).orElse(null);
        return province;
    }

    public void removeProvince(Long id) {
        provinceRepo.deleteById(id);
    }

}
