package com.hongcheng.techinnovte.pojo.vo;


import com.diboot.core.binding.annotation.BindDict;
import lombok.Data;

@Data
public class HumanInfoVO extends HumanInfo {

    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    @BindDict(type = "COMMON_SEX", field = "gender")
    private String genderLabel;

    @BindDict(type = "COMMON_NATION", field = "nationid")
    private String nationLabel;

    @BindDict(type = "COMMON_NATIVETYPE", field = "nativetype")
    private String nativetypeLabel;

    @BindDict(type = "POLITICAL_ORIENTATION", field = "political")
    private String politicalLabel;

}
