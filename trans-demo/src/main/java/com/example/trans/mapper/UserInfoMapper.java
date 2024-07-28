package com.example.trans.mapper;

import com.example.trans.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:20
 * Version:
 */
@Mapper
public interface UserInfoMapper {
    @Insert("insert into user_info (user_name,password) values(#{userName},#{password})")
    Integer insert(String userName, String password);
}
