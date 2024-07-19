package com.xkong.mybatis_demo.mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-19
 * Time: 20:18
 * Version:
 */

import com.xkong.mybatis_demo.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 动态 SQL 练习
 */
@Mapper
public interface UserInfo2Mapper {
    @Insert("<script>" +
            "insert into userinfo (username, `password`, age, " +
            "<if test='gender!=null'>gender, </if>" +
            "phone) " +
            "values (#{username},#{password},#{age}," +
            "<if test='gender!=null'>#{gender},</if>" +
            "#{phone})" +
            "</script>")
    Integer insert(UserInfo userInfo);

    Integer insertByXML(UserInfo userInfo);

    /**
     * 使用 where 标签
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition(UserInfo userInfo);

    /**
     * 使用 trim 标签
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByCondition2(UserInfo userInfo);

    /**
     * 注解的方式
     * @param userInfo
     * @return
     */
    @Select("<script>" +
            "select * from userinfo" +
            "        <where>" +
            "            <if test=\"username != null\">" +
            "                username = #{username}" +
            "            </if>" +
            "            <if test=\"age!=null\">" +
            "                and age = #{age}" +
            "            </if>" +
            "            <if test=\"gender\">" +
            "                gender = #{gender} /* where 标签会自动补齐或删除 where 和 and */" +
            "            </if>" +
            "        </where>" +
            "</script>")
    List<UserInfo> selectByCondition3(UserInfo userInfo);

    /**
     * 使用 trim 标签
     * @param userInfo
     * @return
     */
    Integer updateByCondition(UserInfo userInfo);

    /**
     * 使用 set 标签
     * @param userInfo
     * @return
     */
    Integer updateByCondition2(UserInfo userInfo);

    Integer batchDelete(List<Integer> ids);
}
