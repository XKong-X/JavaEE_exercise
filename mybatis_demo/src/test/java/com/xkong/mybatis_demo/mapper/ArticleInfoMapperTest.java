package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-18
 * Time: 22:36
 * Version:
 */
@Slf4j
@SpringBootTest
class ArticleInfoMapperTest {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void selectById() {
        ArticleInfo articleInfo = articleInfoMapper.selectById(1);
        log.info(articleInfo.toString());
    }

    @Test
    void selectArticleAndUserById() {
        ArticleInfo articleInfo = articleInfoMapper.selectArticleAndUserById(1);
        log.info(articleInfo.toString());
    }
}