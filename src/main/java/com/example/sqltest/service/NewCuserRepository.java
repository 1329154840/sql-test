package com.example.sqltest.service;

import com.example.sqltest.model.Cuser;
import org.apache.catalina.LifecycleState;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-05
 * Time: 11:29
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public interface NewCuserRepository extends CrudRepository<Cuser,String> {
    @Query("SELECT id,name FROM user")
    List<Cuser> findAllCuser();
}
