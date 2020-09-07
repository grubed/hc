package com.hongcheng.techinnovte.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongcheng.techinnovte.pojo.dto.RoleDTO;
import com.hongcheng.techinnovte.common.util.CommonUtil;
import com.hongcheng.techinnovte.entity.SysRole;
import com.hongcheng.techinnovte.entity.SysUserRole;
import com.hongcheng.techinnovte.mapper.SysRoleMapper;
import com.hongcheng.techinnovte.mapper.SysUserRoleMapper;
import com.hongcheng.techinnovte.service.ISysRoleService;

/**
 * <p>
 * 后台角色表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public List<SysRole> getRoles() {
        return this.baseMapper.getRoles();
    }

    public void createRole(RoleDTO roleDTO){
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDTO,sysRole);
        this.baseMapper.insert(sysRole);
    }

    public void createUserRole(Long userId, String role){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRole::getRoleCode, role);
        SysRole sysRole = getOne(queryWrapper);
        
        //判断是否存在
        QueryWrapper<SysUserRole> userole = new QueryWrapper<>();
        userole.lambda().eq(SysUserRole::getUserId, userId).eq(SysUserRole::getRoleId, sysRole.getId());
        if(sysUserRoleMapper.selectCount(userole) == 0) {
        	SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(sysRole.getId());
        	sysUserRoleMapper.insert(sysUserRole);
        }
    }
    public void modifyRole(String id, RoleDTO roleDTO)
    {
        SysRole sysRole = this.baseMapper.selectById(id);
        BeanUtils.copyProperties(roleDTO, sysRole, CommonUtil.getNullPropertyNames(roleDTO));
        this.baseMapper.updateById(sysRole);
    }

    public void deleteRole(String id)
    {
        this.baseMapper.deleteById(id);
    }
}
