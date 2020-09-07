package com.hongcheng.techinnovte.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础数据维目录
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppDataManageMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    /**
     * 目录名称
     */
    private String menuName;

    /**
     * 目录等级
     */
    private Integer menuLevel;

    /**
     * 目录分类
     */
    private String menuType;

    /**
     * 父级目录
     */
    private Integer parId;

    /**
     * 目标表
     */
    private String targetTable;

    /**
     * 目标数据内容
     */
    private String targetDataContent;

    /**
     * 是否末尾节点0否1是
     */
    private Integer isEnd;

    /**
     * 权限等级
     */
    private String menuAuth;

    /**
     * 类型顺序
     */
    private Integer typeOrder;

    /**
     * 目录顺序
     */
    private Integer menuOrder;

    /**
     * 是否可修改0否1是
     */
    private Integer manageAble;


}
