package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 16:44
 * Version:
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String username, String password, HttpSession session) {
        System.out.println("接收到前端的数据");
        // 校验数据合法性
//        System.out.println(username != null);
//        System.out.println(password != null);
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
//            System.out.println("...");
            return false;
        }
        // 进行用户名的密码的校验
        if (!"admin".equals(username) || !"admin".equals(password)) {
            System.out.println("admin".equals(username));
            System.out.println("admin".equals(password));
            return false;
        }
        session.setAttribute("username", "admin");
        return true;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request) {
        // 从 Session 中获取信息
        HttpSession session = request.getSession(false);
        String username = null;
        if (session != null) {
            username = (String) session.getAttribute("username");
        }
        return username;
    }
}
