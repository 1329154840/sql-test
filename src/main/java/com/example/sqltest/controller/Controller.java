package com.example.sqltest.controller;


import com.alibaba.fastjson.JSON;
import com.example.sqltest.model.Cuser;
import com.example.sqltest.model.User;
import com.example.sqltest.service.CuserService;
import com.example.sqltest.service.NewCuserRepository;
import com.example.sqltest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-01
 * Time: 15:43
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@RestController
@Slf4j
public class Controller {
    @Autowired
    UserService userService;

    @Autowired
    CuserService cuserService;

    @Autowired
    NewCuserRepository newCuserRepository;

    @RequestMapping("/createC")
    public String createC(@RequestParam("name") String name){

        Cuser cuser = new Cuser(UUID.randomUUID().toString(), name );
        cuserService.create(cuser);
        log.info("createC name={}",name);
        return "createC ok";
    }

    @RequestMapping("/getAllC")
    public String  getAllC(){
        return JSON.toJSONString(cuserService.getAll());
    }

    @RequestMapping("/getNewAllC")
    public String  getNewAllC(){
        return JSON.toJSONString(newCuserRepository.findAll());
    }

    @RequestMapping("/getUserName")
    public String getUserName(@RequestParam("id") Long id){
        User user = userService.findById(id);
        if (user == null){
            return "no user";
        }
        return user.getName();
    }

    @RequestMapping("/updateByIdC")
    public String updateByIdC(@RequestParam("id") String id,
                             @RequestParam("name") String name){
        try {
            cuserService.updateC(new Cuser(id,name));
        }catch (Exception e){
            log.error("{}",e.getMessage());
            return "fail";
        }
        log.info("updateC id={}",id);
        return "updateByIdC ok";
    }

    @RequestMapping("/deleteByIdC")
    public String deleteC(@RequestParam("id") String id){
        if (cuserService.deleteC(id)){
            log.info("deleteC id={}",id);
            return "delete ok";
        }
       return "fail";
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestParam("id") Long id,
                              @RequestParam("name") String name){
        try {
            userService.update(new User(id, name));
        }catch (Exception e){
            log.error("{}",e.getMessage());
            return "fail";
        }
        log.info("update id={}",id);
        return "updateById ok";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);
        userService.create(user);
        log.info("create id={}",user.getId());
        return "create ok";
    }

    @RequestMapping("/deleteById")
    public String delete(@RequestParam("id") Long id){
        userService.delete(id);
        log.info("delete id={}",id);
        return "delete ok";
    }

    @RequestMapping("/getAll")
    public String  getAll(){
        return JSON.toJSONString(userService.getAll());
    }


}
