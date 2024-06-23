package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 16:17
 * Version:
 */
@RequestMapping("/calc")
@RestController
public class CalcController {
    @RequestMapping("sum")
    public String sum(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "请先输入数据！";
        }
        return "计算结果为：" + (num1 + num2);
    }
}
