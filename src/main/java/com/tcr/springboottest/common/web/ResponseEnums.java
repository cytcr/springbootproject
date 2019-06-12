package com.tcr.springboottest.common.web;

import lombok.Getter;

/**
 * @Description 返回枚举类
 *     状态码定义 0开头请求成功状态
 *              1开头失败状态(不可控未知的错误,内存溢出等错误)
 *              2开头业务状态 (请求参数不合法,违背业务原则等)
 *              3开头权限状态 (权限不足,未登陆等)
 *              ...
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/12 14:27
 */
@Getter
public enum ResponseEnums {
    SUCCESS("0000", "请求成功"),
    ERROR("1000", "请求失败"),
    BUSINESS_ERROR("2001","业务逻辑错误"),
    PARAM_ERROR("2002", "请求参数错误"),
    NO_ACCESS("3001", "权限不足");

    private String status;
    private String msg;

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:29
     * @param code
     * @param msg
     * @return
    */
    ResponseEnums(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
