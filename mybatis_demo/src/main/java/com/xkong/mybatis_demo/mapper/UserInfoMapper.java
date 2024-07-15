package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-15
 * Time: 14:06
 * Version:
 */
@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> selectAll();

    @Select("select * from userinfo where id = #{id}")
    UserInfo selectOne(Integer id);

    @Select("select * from userinfo where id = #{userId}")
    UserInfo selectOne2(@Param("userId") Integer id);
}
