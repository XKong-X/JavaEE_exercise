package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-26
 * Time: 22:53
 * Version:
 */
@RequestMapping("/message")
@RestController
public class MessageController {
    private List<MessageInfo> messageInfos = new ArrayList<>();

    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo) {
        // 校验数据
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())) {
            System.out.println("添加失败！");
            return false;
        }
        // 添加留言
        messageInfos.add(messageInfo);
        System.out.println("添加成功！");
        return true;
    }

    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo() {
        return messageInfos;
    }
}
