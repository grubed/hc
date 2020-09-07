package com.hongcheng.techinnovte.service;

import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.pojo.dto.PermissionDTO;
import com.hongcheng.techinnovte.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台权限表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface ISysPermissionService extends IService<SysPermission> {
    JSONObject getUserPermission(String username);
    List<SysPermission> getPermissions();
    void createPermission(PermissionDTO permissionDTO);
    void modifyPermission(String id, PermissionDTO permissionDTO);
    void deletePermission(String id);
}
