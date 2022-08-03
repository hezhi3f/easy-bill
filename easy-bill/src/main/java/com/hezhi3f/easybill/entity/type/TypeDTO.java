package com.hezhi3f.easybill.entity.type;

import lombok.Data;

import java.util.Date;

@Data
public class TypeDTO {
    private Long id;
    private String type;
    private boolean expend;
    private Date gmtCreated;
    private Date gmtModified;
    private Boolean deleted;
}
