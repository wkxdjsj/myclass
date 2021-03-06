package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User checkUser(String name);
    User login(String name, String password);
}