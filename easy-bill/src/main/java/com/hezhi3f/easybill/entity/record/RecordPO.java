package com.hezhi3f.easybill.entity.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("bill_record")
public class RecordPO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Date time;
    private BigDecimal amount;
    private String memo;
    private Long typeId;
    private Date gmtCreated;
    private Date gmtModified;
    @TableField("is_deleted")
    private Boolean deleted;
}
