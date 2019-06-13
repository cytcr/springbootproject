package com.tcr.springboottest.exception;

import com.tcr.springboottest.common.web.BusinessResponse;
import com.tcr.springboottest.common.web.BusinessResponseUtil;
import com.tcr.springboottest.common.web.ResponseEnums;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 全局处理异常处理类
 * @Author TCR
 * @Email 670830864@qq.com
 * @Date 2019/6/12 17:12
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Log log = LogFactory.getLog(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public BusinessResponse exceptionHandle(Exception e){

        if(e instanceof BusinessException){
            //业务异常 返回业务异常的信息
            log.info(e.getMessage());
            BusinessException busiException = (BusinessException)e;
            //对不同的异常返回不同的状态码
            if (ErrCodeEnums.BUSINESS_ERROR.getErrCode().equals(busiException.getErrCode())){
                return BusinessResponseUtil.failed(ResponseEnums.BUSINESS_FAILDED.getStatus(),e.getMessage());
            }else if(ErrCodeEnums.NO_ACCESS_ERROR.getErrCode().equals(busiException.getErrCode())){
                return BusinessResponseUtil.failed(ResponseEnums.NO_ACCESS_FAILDED.getStatus(),e.getMessage());
            }else if(ErrCodeEnums.NO_DATE_ERROR.getErrCode().equals(busiException.getErrCode())){
                return BusinessResponseUtil.failed(ResponseEnums.NO_RESOURCE_FAILDED.getStatus(),e.getMessage());
            }
            return BusinessResponseUtil.failed(ResponseEnums.BUSINESS_FAILDED.getStatus(),e.getMessage());
        }else{
            //系统异常 返回枚举的异常提示
            log.error(e.getMessage(),e);
            return BusinessResponseUtil.failed(ResponseEnums.FAILDED.getStatus(),ResponseEnums.FAILDED.getMsg());
        }
    }
}
