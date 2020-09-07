package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "sms")
public class SmsDTO {

    @JacksonXmlProperty(localName = "mt")
    private MtDTO mtDTO;

//    @JacksonXmlElementWrapper(useWrapping = false)
//    @JacksonXmlProperty(localName = "order_info")
//    private List<OrderInfoVO> orderList;



}
