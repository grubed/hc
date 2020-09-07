package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApproveDTO {
    private String id;
    private String sts;
    @JsonProperty("dues_type")
    private String duesType;
    @JsonProperty("approval_opinion")
    private String approvalOpinion;
}
