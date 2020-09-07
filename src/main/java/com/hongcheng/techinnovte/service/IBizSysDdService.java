package com.hongcheng.techinnovte.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongcheng.techinnovte.pojo.dto.DictDTO;
import com.hongcheng.techinnovte.entity.BizSysDd;

/**
 * <p>
 * 系统数据字典表 服务类
 * </p>
 *
 * @author sj
 * @since 2020-07-10
 */
public interface IBizSysDdService extends IService<BizSysDd> {
	
    /**
     * @desc 系统初始化
     */
    void dictinit(String key);
    
    List<DictDTO> getDictList(String key, String plistvalue);
    
    /**
     * @desc 根据key获取content
     * @param rediskey
     * @param keys
     * @return
     */
    Map<String, String> getDictContent(String rediskey, Object... keys);

    /**
     * 根据value获取content
     * @param rediskey
     * @param value
     * @return
     */
    String getContentByValue(String rediskey, Object value);
}
