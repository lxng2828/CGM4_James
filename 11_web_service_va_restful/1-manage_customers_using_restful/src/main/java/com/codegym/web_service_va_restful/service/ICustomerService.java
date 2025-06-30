package com.codegym.web_service_va_restful.service;

import java.util.List;

import com.codegym.web_service_va_restful.model.Customer;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
