package com.example.demo.controller;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-26
 * Time: 22:56
 * Version:
 */
@Data
public class MessageInfo {
    private String from;
    private String to;
    private String message;
    private Date CreateTime;
}
