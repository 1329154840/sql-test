package com.example.sqltest.dao;

import com.example.sqltest.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-01
 * Time: 14:55
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Mapper
public interface UserMapper {

    @Select("SELECT id,name FROM user WHERE id=#{id} ")
    User findById(Long id);

    @Select("SELECT id,name FROM user ")
    List<User> getAll();

    @Insert("INSERT INTO user(id, name) VALUES (#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(User user);

    @Update("UPDATE user SET name=#{name} WHERE id=#{id}")
    void update(User user);

    @Delete("Delete FROM user WHERE id=#{id} ")
    void delete(Long id);


}
