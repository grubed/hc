package com.hongcheng.techinnovte.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hongcheng.techinnovte.entity.*;
import com.hongcheng.techinnovte.pojo.dto.RecommendDTO;
import com.hongcheng.techinnovte.pojo.dto.ShareholdDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AllianceMemberApplyVO extends AllianceMemberApply {

    @BindDict(type = "CUST_CATEGORY", field = "category")
    private String categoryLabel;

    @BindDict(type = "CUST_TYPE", field = "type")
    private String typeLabel;

    @BindDict(type = "COMMON_CURRENCY", field = "capitalCurrency")
    private String capitalCurrencyLabel;

    @BindDict(type = "COMMON_PROVINCE", field = "headProvince")
    private String headProvinceLabel;

    @BindDict(type = "COMMON_CITY", field = "headCity")
    private String headCityLabel;

    @BindDict(type = "COMMON_COUNTY", field = "headCounty")
    private String headCountyLabel;

    @BindDict(type = "COMMON_CITY", field = "zjHeadCity")
    private String zjHeadCityLabel;

    @BindDict(type = "CATALOG_PRODUCT", field = "hasCatalogProduct")
    private String hasCatalogProductLabel;

    @BindDict(type = "COMMON_COUNTY", field = "zjHeadCounty")
    private String zjHeadCountyLabel;

    @BindDict(type = "HIGH_TECH", field = "highTech")
    private String highTechLabel;

    @BindField(entity = PlatCustType.class, field = "name", condition = "this.identity=plat_cust_type.code")
    private String identityLabel;

    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    // @BindDict(type = "PLATFORM_TYPE", field = "createPlatform")
    private String createPlatformLabel;
    private String draftingStandardLabel;

    @BindField(entity = PlatDuesType.class, field = "name", condition = "this.duesType=plat_dues_type.code")
    private String duesTypeLabel;

    private String applyFileLabel;

    private String creditcodeFileLabel;

    @BindEntityList(entity = Approval.class, condition = "this.id=type_id and approval.type='alliance_member_apply'")
    private List<Approval> approvalList;

    private String strRegistrationDate;
    private String strHighTechDate;

    private List<String> standards;
    private String standardNameLabel;

    @BindDict(type = "UNDERTAKEN_WORK", field = "hasUndertakenWork")
    private String hasUndertakenWorkLabel;
}
