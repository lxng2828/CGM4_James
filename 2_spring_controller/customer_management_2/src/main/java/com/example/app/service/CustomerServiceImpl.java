package com.example.app.service;

import com.example.app.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Map<Integer, User> userMap = new HashMap<>();
    private static int idCounter = 1;

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User findById(int id) {
        return userMap.get(id);
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        userMap.put(user.getId(), user);
    }
}
