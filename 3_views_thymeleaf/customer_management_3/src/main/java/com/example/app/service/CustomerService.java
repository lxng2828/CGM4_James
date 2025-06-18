package com.example.app.service;

import com.example.app.model.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void Save(Customer customer);

    void Remove(Long id);
}
