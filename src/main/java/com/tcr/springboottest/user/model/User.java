package com.tcr.springboottest.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("USER")
public class User {

    @TableId(type = IdType.UUID)
    private String userId;

    private String userName;

    private String phone;

    private String sex;

    private Date createDate;

}
