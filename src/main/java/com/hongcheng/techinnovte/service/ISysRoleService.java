package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.pojo.dto.RoleDTO;
import com.hongcheng.techinnovte.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台角色表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface ISysRoleService extends IService<SysRole> {
    List<SysRole> getRoles();
    void createRole(RoleDTO roleDTO);
    void createUserRole(Long userId, String role);
    void modifyRole(String id, RoleDTO roleDTO);
    void deleteRole(String id);
}
