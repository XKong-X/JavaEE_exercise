package com.xkong.demo.controller;

import com.xkong.demo.model.DBTypes;
import com.xkong.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-05
 * Time: 20:56
 * Version:
 */
@RestController
public class YmlController {
    @Value("${demo.key1}")
    public String key1;

    @Value("${demo.key2}")
    public String key2;

    @Value("${demo.key3}")
    public Integer key3;

    @RequestMapping("/readYml")
    public String readYml() {
        return key1;
    }

    @Value("${string.str1}")
    public String str1;

    @Value("${string.str2}")
    public String str2;

    @Value("${string.str3}")
    public String str3;

    @Autowired
    public Student student;

    @Autowired
    public DBTypes dbTypes;

    @PostConstruct
    public void init() {
//        System.out.println("key1: " + key1);
//        System.out.println("key2: " + key2);
//        System.out.println("key3: " + key3);
//
//        System.out.println("str1:"+str1);
//        System.out.println("str2:"+str2);
//        System.out.println("str3:"+str3);
        System.out.println("student: " + student);
        System.out.println("dbtypes: " + dbTypes + ", length: " + dbTypes.getName().length);
    }
}
