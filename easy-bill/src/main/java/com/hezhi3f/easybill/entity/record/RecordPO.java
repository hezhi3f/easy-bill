package com.hezhi3f.easybill.entity.record;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecordPO {
    private Long id;
    private Long userId;
    private Date time;
    private BigDecimal amount;
    private String description;
    private Long typeId;
    private Date gmtCreate;
    private Date gmtModified;
}
