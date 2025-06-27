package com.codegym.aop_exception_handling.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codegym.aop_exception_handling.model.User;
import com.codegym.aop_exception_handling.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // public List<User> getAllUser() {
    // List<User> users = userRepository.findAll();
    // return users;
    // }

    public Page<User> getAllUser(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage;
    }

    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User updateUser(User user) {
        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        return userRepository.save(updateUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
