package com.codegym.customer_management.service;

import org.springframework.stereotype.Service;
import com.codegym.customer_management.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final List<User> customers = new ArrayList<>();

    static {
        customers.add(new User("Nguyễn Văn A", 25));
        customers.add(new User("Trần Thị B", 31));
        customers.add(new User("Lê Văn C", 22));
    }

    @Override
    public List<User> findAll() {
        return customers;
    }

    @Override
    public void save(User user) {
        customers.add(user);
    }
}