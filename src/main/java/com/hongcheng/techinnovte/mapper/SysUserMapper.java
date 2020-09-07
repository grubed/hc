package com.hongcheng.techinnovte.mapper;

import com.hongcheng.techinnovte.pojo.dto.UserRoleDTO;
import com.hongcheng.techinnovte.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 运营后台用户表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("SELECT * FROM `sys_user` where username = #{username} and  password = #{password}")
    SysUser getUser(String username, String password);

    @Select("SELECT * FROM `sys_user` where username = #{username}")
    SysUser getUserByUsername(String username);

//    @Select("SELECT a.*, b.role_name FROM sys_user a, sys_role b where a.role_id = b.id")
    List<UserRoleDTO> getUsers();

    @Select("SELECT b.role_name FROM sys_user a, sys_role b where a.role_id = b.id and a.username = #{username}")
    Set<String> getRole(String username);

    @Select("SELECT b.role_name FROM sys_user a, sys_role b where a.role_id = b.id and a.username = #{username}")
    Set<String> getRolePermission(String username);

    Set<String> getPermission(String username);

    @Select("SELECT a.id FROM sys_user a where a.username = #{username}")
    Long getUserIdByUsername(String username);

    @Select("SELECT * FROM sys_user JOIN sys_role ON  role_code = #{rolecode} JOIN sys_user_role ON sys_user.id=sys_user_role.user_id AND sys_role.id = sys_user_role.role_id ")
    SysUser getRoleUser(String rolecode);
}
