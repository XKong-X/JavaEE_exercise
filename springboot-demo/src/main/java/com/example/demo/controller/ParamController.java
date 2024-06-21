package com.example.demo.controller;

import com.example.demo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
