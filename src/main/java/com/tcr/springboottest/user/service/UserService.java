package com.tcr.springboottest.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcr.springboottest.exception.BusinessException;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.vo.UserParamVO;

public interface UserService {

    User getUser(String userId) ;

    void save(User user) throws BusinessException;

    int update(User user) throws BusinessException;

    void delete(String userId) ;

    IPage<User> selectByPage(Page<User> page, UserParamVO userParam) throws BusinessException;

}
