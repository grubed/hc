package com.hongcheng.techinnovte.entity;

import java.util.Date;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 运营后台用户表
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends Base implements Serializable  {

    private static final long serialVersionUID = 1L;
//    @TableId
//    private Long id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    @JSONField(serialize = false)
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    private String email;

    private String qq;

    private String wechart;
    /**
     * 角色ID
     */
//    private Integer roleId;

//    /**
//     * 创建时间
//     */
//    private LocalDateTime createTime;
//
//    /**
//     * 修改时间
//     */
//    private LocalDateTime updateTime;

    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;

    @TableField("CUST_ID")
    private Long custId;
}
