package com.example.demo.mapper;

import com.example.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-20
 * Time: 11:59
 * Version:
 */
@Mapper
public interface MessageMapper {
    @Insert("insert into message_info (`from`,`to`, `message`) values(#{from},#{to},#{message})")
    void insertMessage(MessageInfo messageInfo);

    @Select("select * from message_info where delete_flag=0")
    List<MessageInfo> selectAllMessage();
}
