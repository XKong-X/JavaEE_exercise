package com.xkong.mybatis_demo.controller;

import com.xkong.mybatis_demo.mapper.UserInfoMapper;
import com.xkong.mybatis_demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-15
 * Time: 14:12
 * Version:
 */
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }
}
