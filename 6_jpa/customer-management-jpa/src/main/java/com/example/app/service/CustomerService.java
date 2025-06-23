package com.example.app.service;

import com.example.app.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    void deleteById(Long id);
}
