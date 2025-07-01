package com.example.app.service;

import com.example.app.Repository.PhoneRepository;
import com.example.app.model.Phone;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Optional<Phone> getPhoneById(Long id) {
        return phoneRepository.findById(id);
    }

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

}