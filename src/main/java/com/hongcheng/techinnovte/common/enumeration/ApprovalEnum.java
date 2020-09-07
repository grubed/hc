package com.hongcheng.techinnovte.common.enumeration;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum ApprovalEnum {

    PASS(1, "通过"),
    REJECT(2, "拒绝"),
    FAILED(3, "驳回修改");

    private Integer code;
    private String desc;

    ApprovalEnum(Integer code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
