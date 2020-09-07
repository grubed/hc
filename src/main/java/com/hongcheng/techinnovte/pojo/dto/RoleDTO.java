package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleDTO {

    @ApiModelProperty(value = "角色名字", required = true)
    private String roleName;

    /**
     * 是否有效  1有效  2无效
     */
    @ApiModelProperty(value = "是否有效  1有效  2无效", required = true)
    private String deleteStatus;
}
