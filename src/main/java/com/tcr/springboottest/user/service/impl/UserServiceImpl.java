package com.tcr.springboottest.user.service.impl;

import com.tcr.springboottest.user.mapper.UserMappr;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMappr userMappr;

    @Override
    public User getUser(String userId) {
        return userMappr.selectByPrimaryKey(userId);
    }

    @Override
    public void save(User user) {
        userMappr.insert(user);
    }

    @Override
    public int update(User user) {
        return userMappr.updateByPrimaryKey(user);
    }

    @Override
    public void delete(String userId) {
        userMappr.deleteByPrimaryKey(userId);
    }
}
