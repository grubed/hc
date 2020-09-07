package com.hongcheng.techinnovte.mapper;

import com.hongcheng.techinnovte.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 后台角色表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT * FROM `sys_role`")
    List<SysRole> getRoles();


}
