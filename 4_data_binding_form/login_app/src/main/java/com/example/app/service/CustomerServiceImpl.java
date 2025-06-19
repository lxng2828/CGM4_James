package com.example.app.service;


import com.example.app.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John Doe", "john.doe@codegym.vn", "New York"));
        customers.put(2, new Customer(2, "Jane Smith", "jane.smith@codegym.vn", "London"));
        customers.put(3, new Customer(3, "Peter Jones", "peter.jones@codegym.vn", "Tokyo"));
        customers.put(4, new Customer(4, "Lionel Messi", "messi@codegym.vn", "Miami"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        Set<Integer> allIds = customers.keySet();

        int maxId = 0;
        if (!allIds.isEmpty()) {
            maxId = Collections.max(allIds);
        }

        int newId = maxId + 1;

        customer.setId(newId);

        customers.put(newId, customer);
    }


    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}