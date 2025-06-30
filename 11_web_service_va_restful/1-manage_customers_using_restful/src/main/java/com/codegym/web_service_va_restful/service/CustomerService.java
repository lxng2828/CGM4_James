package com.codegym.web_service_va_restful.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegym.web_service_va_restful.model.Customer;
import com.codegym.web_service_va_restful.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer;
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer save(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

}
