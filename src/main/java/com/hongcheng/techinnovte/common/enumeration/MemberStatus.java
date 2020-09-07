package com.hongcheng.techinnovte.common.enumeration;

public enum MemberStatus {
    NORAML(5, "正常"),
    NO_NORAML(-2, "异常"),
    MEMBERSHIP_FEE(6, "入会缴费"),
    RENEWAL_PAYMENT(7, "续费缴费");
    private Integer STS;
    private String desc;
    MemberStatus(Integer sts, String desc) {
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
