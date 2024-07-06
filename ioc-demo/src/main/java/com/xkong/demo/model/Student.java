package com.xkong.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-06
 * Time: 13:15
 * Version:
 */
@Component
@ConfigurationProperties(prefix = "student")
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
}
