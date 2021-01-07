package com.example.dao;

import com.example.entiy.UserDo;

public class UserDao {

    public UserDo login(UserDo loginUser) {
        if ("admin".equals(loginUser.getUsername()) && "admin".equals(loginUser.getPassword())) {
            UserDo user = new UserDo();
            user.setId(1);
            user.setUsername("admin");
            user.setPassword("admin");
            return user;
        }

        return null;
    }
}
