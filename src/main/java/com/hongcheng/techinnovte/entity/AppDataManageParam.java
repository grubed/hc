package com.hongcheng.techinnovte.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础数据维护查询入参
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppDataManageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private Integer menuId;

    /**
     * 目标表
     */
    private String targetTable;

    /**
     * 目标字段
     */
    private String targetColumn;

    /**
     * 匹配规则
     */
    private String matchRule;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数数据类型
     */
    private String paramDataType;

    /**
     * 参数类型
     */
    private String paramKind;

    /**
     * 顺序
     */
    private Integer paramOrder;


}
