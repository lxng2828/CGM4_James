package com.example.app.service;

import com.example.app.model.User;
import java.util.List;

public interface CustomerService {
    List<User> findAll();

    User findById(int id);

    void save(User user);
}
