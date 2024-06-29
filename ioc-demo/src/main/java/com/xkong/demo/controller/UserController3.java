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
 * Time: 22:05
 * Version:
 */
@Controller
public class UserController3 {


    // 注入方法2：构造方法注入
    private UserService userService;

    @Autowired
    public UserController3(UserService userService) {
        this.userService = userService;
    }


//    public User getUser(Integer id) {
//        return userService.getUser(id);
//    }
}
