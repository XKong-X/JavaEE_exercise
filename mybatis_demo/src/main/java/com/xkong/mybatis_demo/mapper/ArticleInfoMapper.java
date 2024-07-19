package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-18
 * Time: 22:29
 * Version:
 */
@Mapper
public interface ArticleInfoMapper {
    @Select("select * from articleinfo where id=#{articleId}")
    ArticleInfo selectById(Integer articleId);

    /**
     * 多表查询
     */
    @Select("SELECT ta.*,tb.username,tb.age,tb.gender " +
            "FROM articleinfo ta LEFT JOIN userinfo tb ON ta.uid = tb.id WHERE ta.id = #{id}")
    ArticleInfo selectArticleAndUserById(Integer articleId);
}
