package com.hongcheng.techinnovte.service.impl;

import com.hongcheng.techinnovte.common.annotation.Dict;

import com.hongcheng.techinnovte.pojo.dto.FileKV;
import com.hongcheng.techinnovte.pojo.dto.KV;
import com.hongcheng.techinnovte.entity.PlatFileInfo;
import com.hongcheng.techinnovte.service.IBizSysDdService;
import com.hongcheng.techinnovte.service.IPlatFileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BaseService {
    @Autowired
    private IPlatFileInfoService fileservice;

    @Autowired
    private IBizSysDdService dictservice;

    public void compensate(List<T> expertApplyOutDTOList) {
        for(T expertApplyOutDTO : expertApplyOutDTOList) {
            compensate(expertApplyOutDTO);
        }
    }
    public void compensate(T c) {
        // 遍历所有Field:
        for (Field field : c.getClass().getDeclaredFields()) {
            // 获取Field定义的@Range:
            Dict range = field.getAnnotation(Dict.class);
            // 如果@Range存在:
            if(range != null) {
                if(field.getType() == KV.class){
                    try {
                        field.setAccessible(true);
                        KV kv = (KV) field.get(c);
                        kv.setName(dictservice.getContentByValue(range.value(), kv.getCode()));
                    }catch (Exception e) {
                        log.info(e.getMessage());
                    }
                } else if(field.getType() == FileKV.class) {
                    try {
                        field.setAccessible(true);
                        FileKV kv = (FileKV) field.get(c);
                        Map<String, PlatFileInfo> files = fileservice.selectByIds(kv.getFileId());
                        if(null != files.get(kv.getFileId())) {
                            kv.setName(files.get(kv.getFileId()).getFileOriginname());
                        }
                    }catch (Exception e) {
                        log.info(e.getMessage());
                    }
                }
            }
        }
    }
}
