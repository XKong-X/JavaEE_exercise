package com.example.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-28
 * Time: 16:26
 * Version:
 */
@Mapper
public interface LogInfoMapper {
    @Insert("insert into log_info(`user_name`,`op`) values(#{userName},#{op})")
    Integer insertLog(String userName,String op);
}
