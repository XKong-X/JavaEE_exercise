package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-20
 * Time: 19:46
 * Version:
 */
@RestController
public class HelloController {
    @RequestMapping("/sayhi")
    public String sayHi() {
        return "Hi SpringBoot";
    }

    @RequestMapping("/sayhello")
    public String sayHello() {
        return "Hello SpringBoot";
    }
}
