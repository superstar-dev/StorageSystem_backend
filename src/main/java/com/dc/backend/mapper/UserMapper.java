package com.dc.backend.mapper;

import com.dc.backend.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserPojo login(UserPojo user);
}
