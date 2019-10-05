package com.example.demo.dao;

import com.example.demo.service.UserLogin;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserLoginDao {
    UserLogin findUser(String userName, String password);
}
