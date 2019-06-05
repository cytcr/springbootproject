package com.tcr.springboottest.base.vo;

import lombok.Data;

@Data
public class BaseParamVO {

    private long currentPage = 1;//当前页

    private long pageSize = 10;//每页大小


}
