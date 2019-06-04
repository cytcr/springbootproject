package com.tcr.springboottest.user.service;

import com.tcr.springboottest.user.model.User;

public interface UserService {

    User getUser(String userId);

    void save(User user);

    int update(User user);

    void delete(String userId);

}
