package com.hongcheng.techinnovte.mapper;

import com.hongcheng.techinnovte.entity.SysRole;
import com.hongcheng.techinnovte.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.corba.se.spi.ior.ObjectKey;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 角色-权限关联表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    @Select("SELECT a.*, b.*, c.* FROM sys_role_permission a JOIN sys_role b, sys_permission c WHERE a.role_id = b.id AND a.permission_id = c.id")
    List<Map<String, Object>> getRolePermission();

    Set<String> getRolePermissions(@Param("roleIds") List<Integer> roleIds);
}
