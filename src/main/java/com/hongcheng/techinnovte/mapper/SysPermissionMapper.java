package com.hongcheng.techinnovte.mapper;

import com.hongcheng.techinnovte.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongcheng.techinnovte.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台权限表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {


    Map<String, Object> getUserPermission(String username);

    @Select("SELECT * FROM `sys_permission`")
    List<SysPermission> getPermissions();

}
