package com.codegym.customer_management.service;


import com.codegym.customer_management.model.User;
import java.util.List;

public interface CustomerService {
    List<User> findAll();
    void save(User user);
}