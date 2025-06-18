package com.example.app.repository;

import com.example.app.model.Customer;

import java.util.List;


public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}