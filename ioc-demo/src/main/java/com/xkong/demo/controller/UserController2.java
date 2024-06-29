package com.xkong.demo.controller;

import com.xkong.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-29
 * Time: 21:57
 * Version:
 */
@Controller
public class UserController2 {


    // 注入方法1：属性注入
    @Autowired
    private UserService userService;


//    public User getUser(Integer id) {
//        return userService.getUser(id);
//    }
}
