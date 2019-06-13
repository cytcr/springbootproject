package com.tcr.springboottest.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcr.springboottest.common.CommonConstants;
import com.tcr.springboottest.exception.BusinessException;
import com.tcr.springboottest.exception.ErrCodeEnums;
import com.tcr.springboottest.user.mapper.UserMappr;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.service.UserService;
import com.tcr.springboottest.user.vo.UserParamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMappr userMappr;

    @Override
    public User getUser(String userId) {
        if(StringUtils.isEmpty(userId)){
            return null;
        }
        return userMappr.selectByPrimaryKey(userId);
    }

    @Override
    public void save(User user) throws BusinessException{
        if(user == null){
            throw new BusinessException(ErrCodeEnums.PARAM_ERROR.getErrCode(),
                    CommonConstants.PARAMS_UNLAWFULNESS);
        }
        userMappr.insert(user);
    }

    @Override
    public int update(User user) throws BusinessException{
        if(user == null || (user != null && StringUtils.isEmpty(user.getUserId()))){
            throw new BusinessException(ErrCodeEnums.PARAM_ERROR.getErrCode(),
                            CommonConstants.PARAMS_UNLAWFULNESS);
        }
        return userMappr.updateByPrimaryKey(user);
    }

    @Override
    public void delete(String userId) {
        if(StringUtils.isEmpty(userId)){
            return ;
        }
        userMappr.deleteByPrimaryKey(userId);
    }

    @Override
    public IPage<User> selectByPage(Page<User> page, UserParamVO userParam){
        return userMappr.selectByPage(page,userParam);
    }
}
