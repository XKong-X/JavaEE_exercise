package com.example.demo.controller;

import com.example.demo.model.MessageInfo;
import com.example.demo.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-26
 * Time: 22:53
 * Version:
 */
@Slf4j
@RequestMapping("/message")
@RestController
public class MessageController {
//    private List<MessageInfo> messageInfos = new ArrayList<>();
    @Autowired
    private MessageService messageService;

    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo) {
        log.info("发表留言");
        // 校验数据
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())) {
            System.out.println("添加失败！");
            return false;
        }
        // 添加留言
        messageService.addMessage(messageInfo);
        System.out.println("添加成功！");
        return true;
    }

    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo() {
        return messageService.getMessageInfo();
    }
}
