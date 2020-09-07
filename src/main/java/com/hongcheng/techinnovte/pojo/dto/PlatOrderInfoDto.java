package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatOrderInfoDto {
	
	@ApiModelProperty("ID")
    private Long id;
	
	@ApiModelProperty("客户编号")
	@JsonProperty("cust_id")
    private Long custId;
	
	@ApiModelProperty("所属公司名称")
	@JsonProperty("cust_name")
    private String custName;
	
    @ApiModelProperty("订单类型")
    @JsonProperty("order_type")
    private String orderType;
    
    @ApiModelProperty("订单状态")
    @JsonProperty("order_sts")
    private String orderSts;
    
    @ApiModelProperty("缴费URL")
    @JsonProperty("pay_url")
    private String payUrl;

    @ApiModelProperty("缴费上传人")
    @JsonProperty("pay_uperid")
    private Long payUperid;
    
    @ApiModelProperty("发票邮寄省")
    @JsonProperty("mail_province")
    private String mailProvince;

    @ApiModelProperty("发票邮寄市")
    @JsonProperty("mail_city")
    private String mailCity;

    @ApiModelProperty("发票邮寄县")
    @JsonProperty("mail_county")
    private String mailCounty;

    @ApiModelProperty("发票详细地址")
    @JsonProperty("mail_detail")
    private String mailDetail;

    @ApiModelProperty("收件人姓名")
    @JsonProperty("mail_linkman")
    private String mailLinkman;

    @ApiModelProperty("收件人手机")
    @JsonProperty("mail_phone")
    private String mailPhone;
    
    @ApiModelProperty("发票号")
    @JsonProperty("invoice_no")
    private String invoiceNo;
    
    @ApiModelProperty("备注")
    private String remark;
    
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}
