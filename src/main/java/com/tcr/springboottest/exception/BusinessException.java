package com.tcr.springboottest.exception;

import lombok.Getter;

/**
 * @Description 业务异常类
 * @Author TCR
 * @Date 2019/6/12 10:21
*/
public class BusinessException extends Exception{
    private static final long serialVersionUID = 1L;

    /**
     * 默认异常代码 1000
     */
    public static final String DEFAULT_CODE = "1000";

    /**
     * 错误代码 默认 1000
     */
    @Getter
    private final String errCode;

    /**
     * 无参构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:25
     * @return BusinessException
    */
    public BusinessException(){
        super();
        this.errCode = BusinessException.DEFAULT_CODE;
    }

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:25
     * @param msg 异常信息
     * @return BusinessException
    */
    public BusinessException(String msg){
        super(msg);
        this.errCode = BusinessException.DEFAULT_CODE;
    }

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:26
     * @param t 堆栈异常对象
     * @return BusinessException
    */
    public BusinessException(Throwable t){
        super(t);
        this.errCode = BusinessException.DEFAULT_CODE;
    }

    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:27
     * @param errCode 异常代码
     * @param msg 异常信息
     * @return BusinessException
    */
    public BusinessException(String errCode,String msg){
        super(msg);
        this.errCode = errCode;
    }


    /**
     * 构造方法
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:28
     * @param errCode 异常代码
     * @param msg 异常信息
     * @param t 堆栈异常对象
     * @return BusinessException
    */
    public BusinessException(String errCode,String msg,Throwable t){
        super(msg,t);
        this.errCode = errCode;
    }

}
