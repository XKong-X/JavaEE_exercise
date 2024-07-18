package com.xkong.mybatis_demo.mapper;

import com.xkong.mybatis_demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

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
    /**
     * 结果映射
     * 方法一：对字段进行重命名
     * @return
     */
    @Select("select id, username, password, age, gender, phone, delete_flag as deleteFlag, " +
            "create_time as createTime, update_time as updateTime from userinfo")
    List<UserInfo> selectAll();

    /**
     * 结果映射
     * 方法二：使用注解
     * @return
     */
    @Results(id = "BaseMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from userinfo")
    List<UserInfo> selectAll2();

    /**
     * 方法三：使用配置的方式，自动转驼峰
     * @return
     */
    @Select("select * from userinfo")
    List<UserInfo> selectAll3();

    @ResultMap(value = "BaseMap")// 方法二的复用
    @Select("select * from userinfo where id = #{id}")
    UserInfo selectOne(Integer id);

    @Select("select * from userinfo where id = #{userId}")
    UserInfo selectOne2(@Param("userId") Integer id);

    // 返回自增id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, `password`, age, gender, phone) " +
            "values (#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    // Insert的参数进行重命名
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, `password`, age, gender, phone) " +
            "values (#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from userinfo where id=#{id}")
    Integer delete(Integer id);

    @Update("update userinfo set age=#{age} where id=#{id}")
    Integer update(UserInfo userInfo);
}
