package com.example.demo.dao;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserLoginDaoImpl implements UserLoginDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserLogin findUser(String userName, String password) {
        String sql = String.format("SELECT * FROM user WHERE username = '%s' AND password = '%s';", userName, password);
        RowMapper mapper = new UserMapper();
        try{
            UserLogin user = (UserLogin) jdbcTemplate.queryForObject(sql, mapper);
            System.out.println("SQL in DaoImpl is" + sql);
            return user;
        } catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
