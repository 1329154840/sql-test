package com.example.sqltest.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-04
 * Time: 11:22
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Data
@Table("user")
public class Cuser {
    public Cuser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cuser() {
    }

    @PrimaryKey
    private String id;
    private String name;
}
