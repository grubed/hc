package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.pojo.dto.InputConditionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DrlUseService {


    public void prinit(String prtBy, InputConditionDTO integer) {
//        integer = 20;
        log.info("prtBy---" + prtBy + "----" + integer.getKind());
        integer.setKind("2");
    }
}
