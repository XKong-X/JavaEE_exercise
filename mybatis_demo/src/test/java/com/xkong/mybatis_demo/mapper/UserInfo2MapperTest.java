package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-19
 * Time: 20:26
 * Version:
 */
@Slf4j
@SpringBootTest
class UserInfo2MapperTest {
    @Autowired
    private UserInfo2Mapper userInfo2Mapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("111-2");
        userInfo.setPassword("111-2");
        userInfo.setAge(1);
//        userInfo.setGender(1);
        userInfo.setPhone("123456789");
        userInfo2Mapper.insert(userInfo);
    }

    @Test
    void insertByXML() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("111-3");
        userInfo.setPassword("111-2");
        userInfo.setAge(1);
//        userInfo.setGender(1);
//        userInfo.setPhone("123456789");
        userInfo2Mapper.insertByXML(userInfo);
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("lisi");
//        userInfo.setGender(2);
//        userInfo.setAge(1);
        List<UserInfo> userInfos = userInfo2Mapper.selectByCondition(userInfo);
        log.info(userInfos.toString());
    }

    @Test
    void selectByCondition2() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("lisi");
//        userInfo.setGender(2);
//        userInfo.setAge(1);
        List<UserInfo> userInfos = userInfo2Mapper.selectByCondition2(userInfo);
        log.info(userInfos.toString());
    }

    @Test
    void selectByCondition3() {
        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("lisi");
//        userInfo.setGender(2);
//        userInfo.setAge(1);
        List<UserInfo> userInfos = userInfo2Mapper.selectByCondition3(userInfo);
        log.info(userInfos.toString());
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("111");
//        userInfo.setGender(2);
//        userInfo.setAge(1);
        userInfo2Mapper.updateByCondition(userInfo);
    }

    @Test
    void updateByCondition2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("111");
//        userInfo.setGender(2);
//        userInfo.setAge(1);
        userInfo2Mapper.updateByCondition2(userInfo);
    }

    @Test
    void batchDelete() {
        userInfo2Mapper.batchDelete(Arrays.asList(16,17,18));
    }
}