package com.hongcheng.techinnovte.common.enumeration;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;


public enum NormalStatusEnum {
    WATTING_SUBMIT(0, "暂存"),
    WATTING_SRCRETARIAT_VERIFY(1, "待初审"),
    WATTING_SRCRETARIAT_SEC_VERIFY(2, "待复审"),
    FAILED(3, "驳回待修改"),
    REJECT(4, "已拒绝"),
    PASS(5, "已通过"),
    MEMBERSHIP_FEE(6, "入会缴费"),
    RENEWAL_PAYMENT(7, "续费缴费");

    @EnumValue
    private Integer STS;
    private String desc;
    NormalStatusEnum(Integer sts, String desc) {
        this.desc = desc;
        this.STS = sts;
    }

    public Integer getSTS() {
        return STS;
    }
    public String getDesc() {
        return desc;
    }

}
