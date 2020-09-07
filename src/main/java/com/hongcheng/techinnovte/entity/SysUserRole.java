package com.hongcheng.techinnovte.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRole extends Base implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleId;
    private Long userId;
}
