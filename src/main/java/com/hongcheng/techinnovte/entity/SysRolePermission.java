package com.hongcheng.techinnovte.entity;

import java.util.Date;
import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色-权限关联表
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePermission extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
//    @TableId
//    private Long id;
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permissionId;

//    private LocalDateTime createTime;
//
//    private LocalDateTime updateTime;

    /**
     * 是否有效 1有效     2无效
     */
    private String deleteStatus;


}
