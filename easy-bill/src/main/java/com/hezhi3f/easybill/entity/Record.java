package com.hezhi3f.easybill.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Record {
    private Long id;
    private Long userId;
    private Date time;
    private BigDecimal amount;
    private String description;
    private Long typeId;
    private Date gmtCreate;
    private Date gmtModified;
}
