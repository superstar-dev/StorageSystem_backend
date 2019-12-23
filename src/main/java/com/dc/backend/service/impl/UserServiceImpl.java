package com.dc.backend.service.impl;

import com.dc.backend.mapper.UserMapper;
import com.dc.backend.pojo.UserPojo;
import com.dc.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public UserPojo login(UserPojo user) {
        return mapper.login(user);
    }
}
