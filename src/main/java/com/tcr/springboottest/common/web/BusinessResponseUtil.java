package com.tcr.springboottest.common.web;

/**
 * @Description 返回工具类
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/12 14:55
 */
public class BusinessResponseUtil {

    /**
     * 构造返回成功实例
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:57
     * @param data
     * @return BusinessResponse
     */
    public static <T> BusinessResponse success(T data){
        return success(ResponseEnums.SUCCESS.getStatus(),ResponseEnums.SUCCESS.getMsg(),data);
    }

    /**
     * 构造返回成功实例
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:57
     * @param data
     * @return BusinessResponse
    */
    public static <T> BusinessResponse success(String status,String msg,T data){
       return new BusinessResponse<T>(status,msg,data);
    }

    /**
     * 构造返回失败实例
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 14:57
     * @param data
     * @return BusinessResponse
    */
    public static <T> BusinessResponse failed(String status,String msg,T data){
       return new BusinessResponse<T>(status,msg,data);
    }



}
