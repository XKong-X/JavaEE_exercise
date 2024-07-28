package com.example.trans.service;

import com.example.trans.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:33
 * Version:
 */
@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    public Integer logService(String userName,String op) {
        return logInfoMapper.insertLog(userName, op);
    }
}
