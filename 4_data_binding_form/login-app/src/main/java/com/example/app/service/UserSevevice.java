package com.example.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.app.model.User;

@Service
public class UserSevevice {
    private static Map<String, User> userMap = new HashMap<>();
    static {
        userMap.put("user1", new User("user1", "123456", "Nguyen Van A", "user1@gmail.com", 20));
        userMap.put("user2", new User("user2", "123456", "Nguyen Van B", "user2@gmail.com", 25));
        userMap.put("user3", new User("user3", "123456", "Nguyen Van C", "user3@gmail.com", 30));
    }

    public Boolean checkLogin(String account, String password) {
        User user = userMap.get(account);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User getUser(String account) {
        return userMap.get(account);
    }
}
