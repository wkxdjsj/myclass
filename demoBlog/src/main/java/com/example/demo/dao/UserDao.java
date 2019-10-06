package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao {
    User findByName(String name);
    User findByUserNameAndPassword(String userName, String password);
}
