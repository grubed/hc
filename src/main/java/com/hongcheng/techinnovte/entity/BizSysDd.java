package com.hongcheng.techinnovte.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统数据字典表
 * </p>
 *
 * @author sj
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BizSysDd extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    private String listkey;

    /**
     * 属性父值
     */
    private String listparentid;

    /**
     * 属性值
     */
    private String listvalue;

    /**
     * 中文显示
     */
    private String listcontent;

    /**
     * 排序
     */
    private BigDecimal orderby;

    /**
     * 地区编号
     */
    private String areacode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否有效
     */
    private BigDecimal enabled;

    /**
     * 标志1
     */
    private BigDecimal flag1;

    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

    /**
     * 备注3
     */
    private String remark3;

    /**
     * 类型
     */
    private BigDecimal typeid;

    /**
     * 父listvalue
     */
    private String parentlistvalue;

//    /**
//     * 创建时间
//     */
//    private LocalDateTime createdate;
//
//    /**
//     * 修改时间
//     */
//    private LocalDateTime updatedate;

    /**
     * 删除时间
     */
    private Date deletedate;

//    /**
//     * 创建者
//     */
//    private BigDecimal createuserid;
//
//    /**
//     * 修改者
//     */
//    private BigDecimal updateuserid;

    /**
     * 删除者
     */
    private BigDecimal deleteuserid;


}
