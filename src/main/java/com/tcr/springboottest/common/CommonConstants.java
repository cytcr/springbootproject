package com.tcr.springboottest.common;

/**
 * 公共常量类
 * @Author TCR
 * @Email:670830864@qq.com
 * @Date 2019/6/12 10:30
*/
public class CommonConstants {

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
