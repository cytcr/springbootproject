package com.tcr.springboottest.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tcr.springboottest.user.model.User;
import com.tcr.springboottest.user.vo.UserParamVO;

public interface UserMappr extends BaseMapper<User> {

    /**
     * 删除
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(String userId);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    IPage<User> selectByPage(Page page, UserParamVO userParam);
}
