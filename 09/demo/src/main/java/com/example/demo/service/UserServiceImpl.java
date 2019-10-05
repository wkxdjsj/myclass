package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User checkUser(String userName){
        User user = userDao.findByName(userName);
        System.out.println("User in userService impl: " + user);
        return user;
    }

}
