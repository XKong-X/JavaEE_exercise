package com.xkong.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-06
 * Time: 13:48
 * Version:
 */
@Component
@ConfigurationProperties(prefix = "dbtypes")
@Data
public class DBTypes {
//    private List<String> name;
    private String[] name;

    private HashMap<String, String> map;
}