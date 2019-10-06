package com.example.demo.service;

import com.example.demo.dao.UserLoginDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginImpl implements UserLogin{
    @Autowired
    private UserLoginDao userLoginDao;

    public UserLogin checkUser(String userName){
        UserLogin user = UserLoginDao.login(userName, password);
        System.out.println("User in userService impl: " + user);
        return user;
    }
}
