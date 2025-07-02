package com.example.app.service;

import java.util.List;

import com.example.app.model.Customer;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer deleteById(Long id);
}
