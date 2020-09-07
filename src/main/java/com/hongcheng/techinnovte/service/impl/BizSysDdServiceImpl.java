package com.hongcheng.techinnovte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongcheng.techinnovte.common.constants.Constants;
import com.hongcheng.techinnovte.pojo.dto.DictDTO;
import com.hongcheng.techinnovte.entity.BizSysDd;
import com.hongcheng.techinnovte.mapper.BizSysDdMapper;
import com.hongcheng.techinnovte.service.IBizSysDdService;

/**
 * <p>
 * 系统数据字典表 服务实现类
 * </p>
 *
 * @author sj
 * @since 2020-07-10
 */
@Service
public class BizSysDdServiceImpl extends ServiceImpl<BizSysDdMapper, BizSysDd> implements IBizSysDdService {
	
    @Autowired
    protected StringRedisTemplate rediscache;
    
    @PostConstruct
    public void serviceinit() {
    	dictinit(null);
    }
    
    /**
     * @desc 系统初始化
     */
    public void dictinit(String dictkey) {
    	if(StringUtils.isBlank(dictkey)) {
    		Set<String> rediskeys = rediscache.keys(Constants.REDIS_DICT_PREFIX + "*");
    		rediscache.delete(rediskeys);
    		List<String> dbkeys = this.baseMapper.findKeys();
    		for(String key : dbkeys) {
    			List<DictDTO> list = this.baseMapper.getValueByKey(key);
    			rediscache.opsForValue().set(Constants.REDIS_DICT_PREFIX + key, JSON.toJSONString(list));
    		}
    	}else {
    		rediscache.delete(Constants.REDIS_DICT_PREFIX + dictkey);
    		List<DictDTO> list = this.baseMapper.getValueByKey(dictkey);
    		rediscache.opsForValue().set(Constants.REDIS_DICT_PREFIX + dictkey, JSON.toJSONString(list));
    	}
    }
    
    /**
     * @desc 根据rediskey/pvalue 获取字典项列表
     * @return
     */
    public List<DictDTO> getDictList(String rediskey, String pvalue) {
    	List<DictDTO> list = new ArrayList();
    	String dicts = rediscache.opsForValue().get(Constants.REDIS_DICT_PREFIX + rediskey);
    	if(StringUtils.isNotBlank(dicts)) {
    		list = JSON.parseArray(dicts, DictDTO.class);
    	}
    	if(StringUtils.isNotBlank(pvalue)) {
			Iterator<DictDTO> iterator = list.iterator();
            while (iterator.hasNext()) {
            	if(!iterator.next().getParentlistvalue().equals(pvalue)) {
            		iterator.remove();
    			}
            }
    	}
    	return list;
    }
    
    public String getContentByValue(String rediskey, Object value) {
    	if(null == value) {
    		return "";
    	}
		List<DictDTO> list = new ArrayList();
		String dicts = rediscache.opsForValue().get(Constants.REDIS_DICT_PREFIX + rediskey);
		if(StringUtils.isNotBlank(dicts)) {
			list = JSON.parseArray(dicts, DictDTO.class);
		}
		Iterator<DictDTO> iterator = list.iterator();
		while (iterator.hasNext()) {
			DictDTO dict = iterator.next();
			if(dict.getValue().equals(String.valueOf(value))) {
				return dict.getContent();
			}
		}
		return "";
	}
    
    /**
     * @desc 根据key获取content
     * @param rediskey
     * @param keys
     * @return
     */
    public Map<String, String> getDictContent(String rediskey, Object... keys) {
    	Map<String, String> result = new HashMap();
    	List<DictDTO> dictlist = getDictList(rediskey, null);
    	if(keys == null) {
    		return result;
    	}
		for(Object keyobj : keys) {
			String key = String.valueOf(keyobj);
			if(StringUtils.isBlank(key) || result.containsKey(key)) {
				continue;
			}
			for(DictDTO model : dictlist) {
				if(model.getKey().equals(key)) {
					result.put(key, model.getContent());
				}
			}
		}
    	return result;
    }
}