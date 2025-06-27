package com.codegym.customer_province_management.Service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegym.customer_province_management.Service.ICustomerService;
import com.codegym.customer_province_management.model.Customer;
import com.codegym.customer_province_management.model.Province;
import com.codegym.customer_province_management.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Iterable<Customer> findAllByProvice(Province province) {
        return iCustomerRepository.findAllByProvince(province);
    }

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

}