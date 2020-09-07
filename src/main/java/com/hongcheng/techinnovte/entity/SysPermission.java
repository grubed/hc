package com.hongcheng.techinnovte.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台权限表
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
//    @TableId
//    private Long id;
    /**
     * 归属菜单,前端判断并展示菜单使用,
     */
    private String menuCode;

    /**
     * 菜单的中文释义
     */
    private String menuName;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    private String permissionCode;

    /**
     * 本权限的中文释义
     */
    private String permissionName;

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    private Boolean requiredPermission;

    @TableField("menu_id")
    private Long menuId;
}
