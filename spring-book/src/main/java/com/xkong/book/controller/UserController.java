package com.xkong.book.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 0:37
 * Version:
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String username, String password, HttpSession session) {
        // 校验参数
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            System.out.println("用户名或密码为空！");
            return false;
        }
        // 验证用户名和密码
        if ("admin".equals(username) && "admin".equals(password)) {
            // 存储 session
            session.setAttribute("username", username);
            return true;
        }
        System.out.println("用户名或密码错误");
        return false;
    }
}
