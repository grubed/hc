package com.hongcheng.techinnovte.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.diboot.core.entity.BaseEntity;
import com.diboot.core.util.D;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@Accessors(chain = true)
public class Base extends BaseEntity {
    private static final long serialVersionUID = -2267618713371952467L;


    @ApiModelProperty(value = "更新时间", example = "2020-07-14 23:13")
    @JSONField(format = D.FORMAT_DATE_Y4MD)
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

//    @TableId
//    private Long id;
//    /**
//     * 创建时间
//     */
//    @TableField(value = "createdate", fill = FieldFill.INSERT)
//    private Date createTime;
//
//    /**
//     * 修改时间
//     */
//    @TableField(value = "updatedate", fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
//
//    /**
//     * 更新人
//     */
//    @TableField("UPDATEUSERID")
//    private Long updateuserid;
//
//    /**
//     * 创建人
//     */
//    @TableField("CREATEUSERID")
//    private Long createuserid;
}
