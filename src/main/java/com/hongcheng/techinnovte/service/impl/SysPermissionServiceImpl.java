package com.hongcheng.techinnovte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.pojo.dto.PermissionDTO;
import com.hongcheng.techinnovte.common.util.CommonUtil;
import com.hongcheng.techinnovte.entity.SysPermission;
import com.hongcheng.techinnovte.mapper.SysPermissionMapper;
import com.hongcheng.techinnovte.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台权限表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = JSONObject.parseObject(JSON.toJSONString(this.baseMapper.getUserPermission(username)));
        return userPermission;
    }

    public List<SysPermission> getPermissions(){
        return this.baseMapper.getPermissions();
    }
    public void createPermission(PermissionDTO permissionDTO){
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(permissionDTO,sysPermission);
        this.baseMapper.insert(sysPermission);
    }
    public void modifyPermission(String id, PermissionDTO permissionDTO){
        SysPermission sysPermission = this.baseMapper.selectById(id);
        BeanUtils.copyProperties(permissionDTO,sysPermission, CommonUtil.getNullPropertyNames(permissionDTO));
        this.baseMapper.updateById(sysPermission);
    }
    public void deletePermission(String id){
        this.baseMapper.deleteById(id);
    }
}
