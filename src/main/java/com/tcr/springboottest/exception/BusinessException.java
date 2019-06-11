package com.tcr.springboottest.exception;

import lombok.Getter;


public class BusinessException extends Exception{
    private static final long	serialVersionUID	= 1L;

    /**
     * 错误代码
     */
    @Getter
    private final String errCode;

    public BusinessException(){
        super();
        this.errCode = "";
    }

    public BusinessException(String msg){
        super(msg);
        this.errCode = "";
    }

    public BusinessException(Throwable t){
        super(t);
        this.errCode = "";
    }

    public BusinessException(String errCode,String msg){
        super(msg);
        this.errCode = errCode;
    }

    public BusinessException(String errCode,String msg,Throwable t){
        super(msg,t);
        this.errCode = errCode;
    }

}
