package com.example.demo.service;

import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-20
 * Time: 11:55
 * Version:
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public void addMessage(MessageInfo messageInfo) {
        messageMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> getMessageInfo() {
        return messageMapper.selectAllMessage();
    }
}
