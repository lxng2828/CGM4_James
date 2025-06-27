package com.codegym.formregistervalidate.service.impl;

import com.codegym.formregistervalidate.model.User;
import com.codegym.formregistervalidate.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void save(User user) {
        // Giả lập lưu vào bộ nhớ (danh sách)
        userList.add(user);
    }

    // Phương thức mở rộng nếu cần (ví dụ lấy tất cả user)
    public List<User> findAll() {
        return userList;
    }
}
