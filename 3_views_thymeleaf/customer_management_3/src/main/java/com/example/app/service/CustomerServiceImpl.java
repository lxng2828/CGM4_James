package com.example.app.service;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository cs;

    @Autowired
    public CustomerServiceImpl(CustomerRepository cs) {
        this.cs = cs;
    }

    @Override
    public List<Customer> findAll() {
        return cs.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return cs.findById(id);
    }

    @Override
    public void Save(Customer customer) {
        cs.save(customer);
    }

    @Override
    public void Remove(Long id) {
        cs.remove(id);
    }
}
