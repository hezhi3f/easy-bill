package com.hezhi3f.easybill.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecordVO {
    private Long id;
    private Long userId;
    private Date time;
    private BigDecimal amount;
    private String description;
    private Type type;
    private Date gmtCreate;
    private Date gmtModified;
}
