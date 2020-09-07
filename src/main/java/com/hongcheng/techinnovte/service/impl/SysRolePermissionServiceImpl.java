package com.hongcheng.techinnovte.service.impl;

import com.hongcheng.techinnovte.entity.SysRolePermission;
import com.hongcheng.techinnovte.mapper.SysRolePermissionMapper;
import com.hongcheng.techinnovte.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色-权限关联表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {
    public List<Map<String, Object>> getRolePermission(){
        return this.baseMapper.getRolePermission();
    }
    public boolean create(Integer RoleId, Integer permissionId){
        SysRolePermission sysRolePermission = new SysRolePermission();
        sysRolePermission.setDeleteStatus("1");
        sysRolePermission.setPermissionId(permissionId);
        sysRolePermission.setRoleId(RoleId);
        return save(sysRolePermission);
    }
}
