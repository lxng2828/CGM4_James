package com.codegym.aop_exception_handling.service;

import java.util.List;

import com.codegym.aop_exception_handling.model.Customer;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer delete(Long id);
}
