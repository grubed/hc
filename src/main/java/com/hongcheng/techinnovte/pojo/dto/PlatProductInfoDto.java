package com.hongcheng.techinnovte.pojo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatProductInfoDto {
	
	@ApiModelProperty("ID")
    private Long id;

	@ApiModelProperty("产品名称")
	@JsonProperty("pro_name")
    private String proName;

	@ApiModelProperty("产品大类")
	@JsonProperty("pro_type_a")
    private String proTypeA;

	@ApiModelProperty("产品小类")
	@JsonProperty("pro_type_b")
    private String proTypeB;
	
	@ApiModelProperty("产品细类")
	@JsonProperty("pro_type_c")
    private String proTypeC;
	
	@ApiModelProperty("产品详情")
	@JsonProperty("pro_detail")
    private String proDetail;

	@ApiModelProperty("发布日期")
	@JsonProperty("pub_date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pubDate;

	@ApiModelProperty("版本及型号")
	@JsonProperty("pro_version")
    private String proVersion;

	@ApiModelProperty("联系人")
    private String linkman;

	@ApiModelProperty("联系电话")
    private String linkphone;

	@ApiModelProperty("宣传图")
	@JsonProperty("pro_pubimage")
    private String proPubimage;

	@ApiModelProperty("自主产品类型")
	@JsonProperty("indepen_type")
    private String indepenType;

	@ApiModelProperty("自主产品附件")
	@JsonProperty("pro_declare")
    private String proDeclare;

	@ApiModelProperty("宣传手册")
	@JsonProperty("pro_brochure")
    private String proBrochure;

	@ApiModelProperty("功能说明书")
	@JsonProperty("pro_function")
    private String proFunction;

	@ApiModelProperty("公开标志")
	@JsonProperty("open_flag")
    private String openFlag;

	@ApiModelProperty("所属公司ID")
	@JsonProperty("cust_id")
    private Long custId;
	
	@ApiModelProperty("所属公司名称")
	@JsonProperty("cust_name")
    private String custName;
	
	@ApiModelProperty("是否核心产品")
	@JsonProperty("core_flag")
    private String coreFlag;
    
	@ApiModelProperty("是否有实物展示")
	@JsonProperty("display_flag")
    private String displayFlag;
    
	@ApiModelProperty("实物展示内容")
	@JsonProperty("display_content")
    private String displayContent;
    
	@ApiModelProperty("应用场景")
	@JsonProperty("pro_appscene")
    private String proAppscene;
	
	@ApiModelProperty("产品状态")
	@JsonProperty("pro_sts")
	private String proSts;
	
	@ApiModelProperty("IDS")
    private String ids;
	
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}
