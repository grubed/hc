package com.hongcheng.techinnovte.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongcheng.techinnovte.entity.SysUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    @Select("SELECT b.role_code FROM sys_user_role a JOIN sys_role b WHERE a.user_id = #{userId} AND a.role_id = b.id")
    Set<String> getRoleCodes(String userId);

    @Select("SELECT b.id FROM sys_user_role a JOIN sys_role b WHERE a.user_id = #{userId} AND a.role_id = b.id")
    Set<Integer> getRoleIds(String userId);
}
