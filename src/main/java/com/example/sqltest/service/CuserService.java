package com.example.sqltest.service;

import com.example.sqltest.model.Cuser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-04
 * Time: 11:25
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public interface CuserService {
    void create(Cuser cuser);

    List<Cuser> getAll();

    void updateC(Cuser cuser);

    boolean deleteC(String id);
}
