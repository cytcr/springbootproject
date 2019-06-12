package com.tcr.springboottest.common.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 公共返回类
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/12 11:41
 */
@Getter
@Setter
@ToString
public class BusinessResponse<T> implements Serializable {

    //状态码
    private String status;
    //返回请求信息
    private String msg;
    //返回实体业务数控
    private T data;

    /**
     * 无参构造
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:17
     * @return BusinessResponse
    */
    public BusinessResponse(){
    }

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:18
     * @param status 状态
     * @param msg 信息
     * @return BusinessResponse
    */
    public BusinessResponse(String status,String msg){
        this.status = status;
        this.msg = msg;
    }

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:18
     * @param status 状态
     * @param msg 信息
     * @return BusinessResponse
    */
    public BusinessResponse(String status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
