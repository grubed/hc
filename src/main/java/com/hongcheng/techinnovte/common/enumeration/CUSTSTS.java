package com.hongcheng.techinnovte.common.enumeration;



public enum CUSTSTS {
    WATTING_SUBMIT(0, "待提交申请"),
    WATTING_SRCRETARIAT_VERIFY(1, "待秘书处审核"),
    WATTING_SRCRETARIAT_SEC_VERIFY(2, "待秘书处二次审核"),
    FAILED(3, "审核不通过"),
    MEMBERSHIP_FEE(4, "入会缴费"),
    NORMAL(5, "正常"),
    RENEWAL_PAYMENT(6, "续费缴费"),
    WATTING(-1, "待填写");
    private Integer value;
    private String desc;
    CUSTSTS(Integer value, String desc) {
        this.desc = desc;
        this.value = value;
    }
    public Integer getValue(){
        return this.value;
    }
    private String getDesc() {
        return this.desc;
    }
}