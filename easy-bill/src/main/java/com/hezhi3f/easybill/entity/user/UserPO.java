package com.hezhi3f.easybill.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;


@Data
@TableName("bill_user")
public class UserPO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    @TableField("phone_number")
    private String phoneNumber;
    private String email;
    /**
     * 0-未知 1-男 2-女
     */
    private Integer gender;
    private Integer age;
    private String secret;
    @TableField("gmt_created")
    private Date gmtCreated;
    @TableField("gmt_modified")
    private Date gmtModified;
    @TableField("is_deleted")
    private Boolean deleted;
}
