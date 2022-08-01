package com.hezhi3f.easybill.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private String phoneNumber;
    private String email;
    private Boolean gender;
    private String age;
    private Date gmtCreate;
    private Date gmtModified;
}
