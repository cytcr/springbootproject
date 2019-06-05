package com.tcr.springboottest.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.service.UserService;
import com.tcr.springboottest.user.vo.UserParamVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增")
    @PutMapping
    public String saveUser(User user){

        userService.save(user);
        return "OK";
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{userId}")
    public User getUser( @PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public IPage<User> selectByPage(UserParamVO userParam){
        Page<User> page = new Page<>(userParam.getCurrentPage(),userParam.getPageSize());
        return userService.selectByPage(page, userParam);
    }

    @ApiOperation(value = "更新")
    @PostMapping
    public String update(User user){
        userService.update(user);
        return "OK";
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        userService.delete(userId);
        return "OK";
    }
}
