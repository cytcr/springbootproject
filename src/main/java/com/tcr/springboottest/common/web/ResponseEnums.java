package com.tcr.springboottest.common.web;

import lombok.Getter;

/**
 * @Description 返回枚举类
 *     状态码定义 0开头请求成功状态
 *              1开头系统异常导致的失败状态(不可控未知的错误,内存溢出等错误)
 *              2开头业务系统导致的失败状态 (请求参数不合法,违背业务原则等)
 *              3开头权限不足导致的失败状态 (权限不足,未登陆等)
 *              4开头资源不存在导致的失败状态
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/12 14:27
 */
@Getter
public enum ResponseEnums {
    SUCCESS("0000", "请求成功"),
    FAILDED("1000", "请求失败，未知异常"),
    BUSINESS_FAILDED("2001","业务逻辑错误"),
    NO_ACCESS_FAILDED("3001", "权限不足"),
    NO_RESOURCE_FAILDED("4001", "请求资源不存在");

    private String status;
    private String msg;

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:29
     * @param msg
     * @return
    */
    ResponseEnums(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
