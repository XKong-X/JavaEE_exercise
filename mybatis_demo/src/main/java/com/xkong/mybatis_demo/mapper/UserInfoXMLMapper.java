package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-17
 * Time: 23:45
 * Version:
 */
@Mapper
public interface UserInfoXMLMapper {
    List<UserInfo> selectAll();

    List<UserInfo> selectAll2();

    Integer insert(UserInfo userInfo);

    Integer insert2(@Param("userInfo") UserInfo userInfo);

    Integer delete(Integer id);

    Integer update(UserInfo userInfo);
}
