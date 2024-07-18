package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-18
 * Time: 0:02
 * Version:
 */
@Slf4j
@SpringBootTest
class UserInfoXMLMapperTest {
    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void selectAll() {
        List<UserInfo> userInfos = userInfoXMLMapper.selectAll();
        log.info(userInfos.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> userInfos = userInfoXMLMapper.selectAll2();
        log.info(userInfos.toString());
    }


    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setPassword("0000");
        userInfo.setAge(1);
        userInfo.setGender(2);
        userInfo.setPhone("1123654987");
        Integer result = userInfoXMLMapper.insert(userInfo);
        log.info("影响行数：{}, 插入的结果：{}", result, userInfo.getId());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setPassword("0000");
        userInfo.setAge(1);
        userInfo.setGender(2);
        userInfo.setPhone("1123654987");
        Integer result = userInfoXMLMapper.insert2(userInfo);
        log.info("影响行数：{}, 插入的结果：{}", result, userInfo.getId());
    }

    @Test
    void delete() {
        userInfoXMLMapper.delete(11);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setGender(3);
        userInfo.setId(12);
        userInfoXMLMapper.update(userInfo);
    }
}