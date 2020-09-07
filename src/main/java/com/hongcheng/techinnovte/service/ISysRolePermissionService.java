package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色-权限关联表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {
    List<Map<String, Object>> getRolePermission();
    boolean create(Integer RoleId, Integer permissionId);
}
