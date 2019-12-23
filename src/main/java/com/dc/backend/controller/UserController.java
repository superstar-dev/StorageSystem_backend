package com.dc.backend.controller;

import com.dc.backend.pojo.UserPojo;
import com.dc.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

//    @Autowired
//    DataSource dataSource;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody UserPojo user) {
//        System.out.println(dataSource);
        log.info("{} come in...", user);
        HashMap<String, Object> msg = new HashMap<>();
        UserPojo u = service.login(user);
        System.out.println(u);
        msg.put("msg", "ok");
        msg.put("user", u);
        return msg;
    }
}
