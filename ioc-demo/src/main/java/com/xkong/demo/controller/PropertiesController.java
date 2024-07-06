package com.xkong.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-03
 * Time: 13:11
 * Version:
 */
@RestController
public class PropertiesController {
//    // 读配置文件
//    @Value("${demo.key1}")
//    private String key1;
    // 去掉 $ 符号就是把双引号中的内容当字符串返回
    @Value("{demo.key1}")
    private String key1;

    @RequestMapping("/readKey")
    public String readKey() {
        return "读到的配置文件key1：" + key1;
    }
}
