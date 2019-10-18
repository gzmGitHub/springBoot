package com.neo.service.impl;

import com.neo.dao.dao1.UserDao1;
import com.neo.dao.dao2.UserDao2;
import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao1 userDao1;

    @Autowired
    private UserDao2 userDao2;

    @Override
    public User getUser1(User user) {
        User user1=userDao1.selectUser(user);
        return user1;
    }

    @Override
    public User getUser2(User user) {
        User user2=userDao2.selectUser(user);
        return user2;
    }
}
