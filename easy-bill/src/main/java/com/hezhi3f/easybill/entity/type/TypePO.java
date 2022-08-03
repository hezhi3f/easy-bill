package com.hezhi3f.easybill.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TypePO {
    private Long id;
    private String type;
    private boolean expend;
    private Date gmtCreated;
    private Date gmtModified;
    private Boolean deleted;
}
