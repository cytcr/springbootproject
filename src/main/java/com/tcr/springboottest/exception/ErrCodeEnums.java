package com.tcr.springboottest.exception;

import lombok.Getter;

/**
 * @Description 异常编码枚举类
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/13 16:40
 */
@Getter
public enum ErrCodeEnums {
    SYSTEM_ERROR("100", "系统异常"),
    BUSINESS_ERROR("201","业务逻辑错误"),
    PARAM_ERROR("202", "请求参数错误"),
    NO_DATE_ERROR("203", "请求数据不存在"),
    NO_ACCESS_ERROR("301", "权限不足");

    private String errCode;
    private String msg;

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/13 16:46
     * @param errCode
     * @param msg
     * @return
    */
    ErrCodeEnums(String errCode,String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }
}
