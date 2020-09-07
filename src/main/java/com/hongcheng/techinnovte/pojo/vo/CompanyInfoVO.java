package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntityList;
import lombok.Data;

import java.util.List;

@Data
public class CompanyInfoVO extends CompanyInfo {

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

    @BindDict(type = "COMMON_COUNTY", field = "zjHeadCounty")
    private String zjHeadCountyLabel;

    @BindEntityList(entity = ShareholderInfo.class, condition = "this.id=company_id")
    private List<ShareholderInfo> shareholderInfoList;
}
