package com.hongcheng.techinnovte.pojo.bean;

import com.hongcheng.techinnovte.entity.SysRole;
import com.hongcheng.techinnovte.entity.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

@Data
public class User {
    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户信息")
    private SysUser user;

    @ApiModelProperty("角色列表")
    private Set<String> roles;
    @ApiModelProperty("权限列表")
    private Set<String> permissions;
}
