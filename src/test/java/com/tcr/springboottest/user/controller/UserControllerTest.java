package com.tcr.springboottest.user.controller;

import com.tcr.springboottest.exception.BusinessException;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser()throws Exception {
        User u = new User();
        u.setUserName("李元霸");
        u.setPhone("13888888888");
        u.setCreateDate(new Date());
        userService.save(u);
        System.out.println("新增ID"+u.getUserId());
    }

    @Test
    public void getUser() {
        User user = userService.getUser("6a4afba01e1e4225a15a1278f6c19f7a");
        System.out.println(user == null ?"查询失败":user.toString());
    }

    @Test
    public void update() {
        try {
            testException(2);
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteUser() {
    }

    public void testException(int a) throws BusinessException {
        if(a>1){
            throw new BusinessException("10","1");
        }else{
            System.out.println(a);
        }
    }
}