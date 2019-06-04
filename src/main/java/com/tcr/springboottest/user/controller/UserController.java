package com.tcr.springboottest.user.controller;

import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public String saveUser(User user){

        userService.save(user);
        return "OK";
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public User getUser( @PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PostMapping
    public String update(User user){
        userService.update(user);
        return "OK";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        userService.delete(userId);
        return "OK";
    }
}
