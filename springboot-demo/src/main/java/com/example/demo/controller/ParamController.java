package com.example.demo.controller;

import com.example.demo.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-21
 * Time: 21:38
 * Version:
 */
@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name) {
        return "接收到的参数name：" + name;
    }

    @RequestMapping("/m2")
    public String m2(String name, Integer age) {
        return "接收到的参数name：" + name + ", age：" + age;
    }

    @RequestMapping("/m3")
    public String m3(String name, int age) {
        return "接收到的参数name：" + name + ", age：" + age;
    }

    @RequestMapping("/m4")
    public String m4(Person person) {
        return "接收到的参数person：" + person.toString();
    }

    @RequestMapping("/m5")
    public String m5(@RequestParam(value = "name", required = false) String username) {
        return "接收到的参数 username：" + username;
    }

    @RequestMapping("/m6")
    public String m6(String[] arrayParam) {
        return "接收到的参数 arrayParam：" + Arrays.toString(arrayParam) + ", 长度： " + arrayParam.length;
    }

    @RequestMapping("/m7")
    public String m7(@RequestParam(required = false) List<String> listParam) {
        return "接收到的参数 listParam：" + listParam + ", 长度： " + listParam.size();
    }

    @RequestMapping("/m8")
    public String m8(@RequestBody Person person) {
        return "接收到的参数person：" + person.toString();
    }

    @RequestMapping("/m9/{userId}/{name}")
    public String m9(@PathVariable Integer userId, @PathVariable("name") String username) {
        return "userId：" + userId + ", username: " + username;
    }

    // 获取文件并保存
    @RequestMapping("/m10")
    public String m10(@RequestPart MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:\\Github\\My\\JavaEE_exercise\\springboot-demo\\temp\\"
                + file.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName() + ":" + cookie.getValue());
//            }
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            });
        }
        return "获取 cookie 成功";
    }

    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue String aaa, @CookieValue String bbb) {
        return "cookie 中的值 aaa：" + aaa + ", bbb：" + bbb;
    }

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", "zhangsan");
        return "success";
    }
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            return "登录用户：" + username;
        }
        return "session 为空";
    }
    @RequestMapping("/getSession2")
    public String getSession2(@SessionAttribute(required = false) String username) {
        return "username: " + username;
    }
    @RequestMapping("/getSession3")
    public String getSession3(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "登录用户：" + username;
    }
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return "userAgent: " + userAgent;
    }

    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent) {
        return "userAgent: " + userAgent;
    }
}
