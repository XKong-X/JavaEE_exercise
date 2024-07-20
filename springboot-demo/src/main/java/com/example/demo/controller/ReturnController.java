package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-23
 * Time: 15:02
 * Version:
 */
@RequestMapping("/return")
//@RestController
@Controller
public class ReturnController {
    @RequestMapping("/index")
    public String returnIndex() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData() {
        return "返回视图需要的数据";
    }
    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml() {
        return "<h1>返回 html 数据</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson() {
        Person person = new Person();
        person.setId(1);
        person.setAge(18);
        person.setName("lisi");
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMap")
    public Map<String, String> returnMap() {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        return map;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(401);
        return "设置状态码";
    }

    @ResponseBody
    @RequestMapping(value = "/r1", produces = "application/json; charset=utf8")
//    @RequestMapping(value = "/r1")
    public String r1() {
        return "{ 'OK':1 }";
    }

    @ResponseBody
    @RequestMapping(value = "/r2", produces = "application/json; charset=utf8")
    public String r2(HttpServletResponse response) {
        response.setHeader("myHead", "myHead");
        return "{ 'OK':1 }";
    }
}
