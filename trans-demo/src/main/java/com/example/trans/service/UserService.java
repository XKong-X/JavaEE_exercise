package com.example.trans.service;

import com.example.trans.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:30
 * Version:
 */
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public Integer insertUser(String userName, String password) {
        return userInfoMapper.insert(userName, password);
    }
}
