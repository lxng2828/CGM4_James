package com.example.app.service;

import com.example.app.model.Customer;
import com.example.app.model.Province;
import com.example.app.repository.CustomerRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        List<Customer> customerList = customerRepo.findAll();
        return customerList;
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    public List<Customer> findAllByProvince(Province province) {
        return customerRepo.findAllByProvince(province);
    }

    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        return customerOptional.orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepo.save(customer);
        return savedCustomer;
    }

    public Customer editCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        return customerOptional.orElse(null);

    }

    public void removeCustomer(Long id) {
        customerRepo.deleteById(id);
    }

}
