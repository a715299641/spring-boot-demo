package com.example.ceshi.ceshi01.service;

import com.example.ceshi.ceshi01.entity.User;
import com.example.ceshi.ceshi01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
