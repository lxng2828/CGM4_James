package com.codegym.aop_exception_handling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegym.aop_exception_handling.model.Customer;
import com.codegym.aop_exception_handling.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(id);
            return customerOptional.get();
        }
        return null;
    }
}