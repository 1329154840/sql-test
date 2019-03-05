package com.example.sqltest.service;

import com.example.sqltest.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-01
 * Time: 15:52
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public interface UserService {
   User findById(Long id);

   void create(User user);

   void update(User user);

   void delete(Long id);

   List<User> getAll();
}
