package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

@Data
public class PermissionDTO {
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

    private Long menuId;
}
