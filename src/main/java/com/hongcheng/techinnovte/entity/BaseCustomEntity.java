package com.hongcheng.techinnovte.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import com.diboot.core.entity.BaseEntity;
import com.diboot.core.util.D;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseCustomEntity extends BaseEntity {
    private static final long serialVersionUID = -2267618713371952467L;


    @ApiModelProperty(value = "更新时间", example = "2020-07-14 23:13")
    @JSONField(format = D.FORMAT_DATE_Y4MD)
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

}
