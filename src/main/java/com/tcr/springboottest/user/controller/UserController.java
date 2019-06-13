package com.tcr.springboottest.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcr.springboottest.common.CommonConstants;
import com.tcr.springboottest.common.web.BusinessResponse;
import com.tcr.springboottest.common.web.BusinessResponseUtil;
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
@RestControllerAdvice
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增,返回新增后的用户ID")
    @PutMapping
    public BusinessResponse saveUser(User user) throws Exception{
        userService.save(user);
        return BusinessResponseUtil.success(user.getUserId());
    }

    @ApiOperation(value = "查询一个用户")
    @GetMapping("/{userId}")
    public BusinessResponse getUser( @PathVariable("userId") String userId)throws Exception{
        return BusinessResponseUtil.success(userService.getUser(userId));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public BusinessResponse selectByPage(UserParamVO userParam)throws Exception{
        Page<User> page = new Page<>(userParam.getCurrentPage(),userParam.getPageSize());
        return BusinessResponseUtil.success(userService.selectByPage(page, userParam));
    }

    @ApiOperation(value = "更新一个用户")
    @PostMapping
    public BusinessResponse update(User user)throws Exception{
        userService.update(user);
        return BusinessResponseUtil.success(CommonConstants.OP_SUCESS);
    }

    @ApiOperation(value = "删除一个用户")
    @DeleteMapping("/{userId}")
    public BusinessResponse deleteUser(@PathVariable("userId") String userId)throws Exception{
        userService.delete(userId);
        return BusinessResponseUtil.success(CommonConstants.OP_SUCESS);
    }
}
