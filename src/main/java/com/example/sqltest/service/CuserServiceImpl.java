package com.example.sqltest.service;

import com.datastax.driver.core.Session;
import com.example.sqltest.model.Cuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-04
 * Time: 11:26
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Service
public class CuserServiceImpl implements CuserService{
    @Autowired
    private CassandraTemplate template;

    @Autowired
    private Session session;

    @Override
    public void create(Cuser cuser) {
        template.insert(cuser);
    }

    @Override
    public void updateC(Cuser cuser) {
        template.update(cuser);
    }

    @Override
    public boolean deleteC(String id) {
        return template.deleteById(id,Cuser.class);

    }

    @Override
    public List<Cuser> getAll() {
        return template.select("SELECT id,name FROM user",Cuser.class);
    }
}
