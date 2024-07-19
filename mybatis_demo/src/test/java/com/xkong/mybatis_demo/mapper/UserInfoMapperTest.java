package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-15
 * Time: 21:25
 * Version:
 */
@Slf4j
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
        log.info("setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown");
    }

    @Test
    void selectAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        log.info(list.toString());
    }

    @Test
    void selectAll2() {
        List<UserInfo> list = userInfoMapper.selectAll2();
        log.info(list.toString());
    }

    @Test
    void selectAll3() {
        List<UserInfo> list = userInfoMapper.selectAll3();
        log.info(list.toString());
    }

    @Test
    void selectOne() {
        log.info(userInfoMapper.selectOne(1).toString());
    }

    @Test
    void selectOne2() {
        log.info(userInfoMapper.selectOne(1).toString());
    }


    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("123456789");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 方法执行结果：{}, 自增ID: {}", result, userInfo.getId());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(6);
        userInfo.setGender(0);
        userInfo.setPhone("123456789");

        Integer result = userInfoMapper.insert(userInfo);
        log.info("insert 方法执行结果：{}, 自增ID: {}", result, userInfo.getId());
    }

    @Test
    void delete() {
        userInfoMapper.delete(6);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(8);
        userInfo.setId(11);
        Integer result = userInfoMapper.update(userInfo);
        if (result > 0) {
            log.info("数据修改成功");
        }
    }

    @Test
    void selectUserBySort() {
        log.info(userInfoMapper.selectUserBySort("asc").toString());
    }

    @Test
    void selectUserByLike() {
        log.info(userInfoMapper.selectUserByLike("asc").toString());
    }
}