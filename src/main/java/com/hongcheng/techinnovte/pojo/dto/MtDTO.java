package com.hongcheng.techinnovte.pojo.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class MtDTO {
    @JacksonXmlProperty(localName = "status")
    private String status;
    @JacksonXmlProperty(localName = "msgid")
    private String msgid;
}
