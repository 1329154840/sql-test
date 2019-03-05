package com.example.sqltest.service;

import com.example.sqltest.dao.UserMapper;
import com.example.sqltest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-01
 * Time: 15:47
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public void create(User user) {
        userMapper.create(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
