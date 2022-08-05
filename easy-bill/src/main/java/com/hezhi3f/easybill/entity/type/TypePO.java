package com.hezhi3f.easybill.entity.type;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bill_type")
public class TypePO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String type;
    @TableField("is_expend")
    private Boolean expend;
    private Date gmtCreated;
    private Date gmtModified;
    @TableField("is_deleted")
    private Boolean deleted;
}
