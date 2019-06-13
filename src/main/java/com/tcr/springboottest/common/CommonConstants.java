package com.tcr.springboottest.common;

/**
 * 公共常量类
 * @Author TCR
 * @Email:670830864@qq.com
 * @Date 2019/6/12 10:30
*/
public class CommonConstants {

    public static final String OP_SUCESS = "操作成功";

    public static final String OP_FAILED = "操作失败";

    public static final String PARAMS_UNLAWFULNESS = "参数不合法";

    /**
     * 是或者否
     * @Author TCR
     * @Email:670830864@qq.com
     * @Date 2019/6/12 10:36
    */
    public enum YesOrNo{
        //是或者否
        是("1"),否("0");

        private String	value;

        YesOrNo(String value)
        {
            this.value = value;
        }
        public String getValue()
        {
            return value;
        }
    }
}
