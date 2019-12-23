package com.dc.backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserPojo {
    private Integer uid;
    private String uname;
    private String account;
    private String pwd;
    private Date createAt;
    private Date updateAt;
}
