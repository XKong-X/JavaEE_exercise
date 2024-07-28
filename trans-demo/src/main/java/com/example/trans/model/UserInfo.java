package com.example.trans.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:07
 * Version:
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
