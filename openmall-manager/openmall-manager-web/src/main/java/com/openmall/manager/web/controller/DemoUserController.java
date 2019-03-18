package com.openmall.manager.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openmall.manager.pojo.DemoUser;
import com.openmall.manager.service.DemoUserService;

@RestController
@RequestMapping("demo")
public class DemoUserController {

    @Autowired
    private DemoUserService demoUserService;

    @RequestMapping("index")
    public List<DemoUser> index(){

        List<DemoUser> allUsers = demoUserService.getAll();

        return allUsers;
    }
}