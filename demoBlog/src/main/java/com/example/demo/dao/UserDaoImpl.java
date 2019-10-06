package com.example.demo.dao;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByName(String name) {
        String sql = String.format("SELECT * FROM user WHERE name = '%s';", name);
        RowMapper mapper = new UserMapper();
        try{
            User user = (User) jdbcTemplate.queryForObject(sql, mapper);
            System.out.println("SQL in DaoImpl is" + sql);
            return user;
        } catch (EmptyResultDataAccessException e){
            return new User();
        }

    }
}
