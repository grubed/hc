package com.hongcheng.techinnovte.pojo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class UserRoleDTO {

    private Integer id;
    private String username;

//    private String password;
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;


    private String roleName;
}
