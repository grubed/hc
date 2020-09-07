package com.hongcheng.techinnovte.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台角色表
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRole extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
//    @TableId
//    private Long id;
    /**
     * 角色名
     */
    private String roleName;
//
//    private LocalDateTime createTime;
//
//    private LocalDateTime updateTime;

    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;

    private String roleCode;
//
}
