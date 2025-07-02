package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer deleteById(Long id) {
        Customer customer = findById(id);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}

