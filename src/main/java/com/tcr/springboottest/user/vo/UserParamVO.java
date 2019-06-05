package com.tcr.springboottest.user.vo;

import com.tcr.springboottest.base.vo.BaseParamVO;
import lombok.Data;

@Data
public class UserParamVO extends BaseParamVO {

    private String userName;

    private String phone;
}
