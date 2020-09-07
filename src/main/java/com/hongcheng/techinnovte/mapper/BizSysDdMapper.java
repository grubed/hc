package com.hongcheng.techinnovte.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongcheng.techinnovte.pojo.dto.DictDTO;
import com.hongcheng.techinnovte.entity.BizSysDd;

/**
 * <p>
 * 系统数据字典表 Mapper 接口
 * </p>
 *
 * @author sj
 * @since 2020-07-10
 */
public interface BizSysDdMapper extends BaseMapper<BizSysDd> {
    List<DictDTO> getDict(String key, String plistvalue);
    
    List<String> findKeys();
    
    List<DictDTO> getValueByKey(@Param("key") String key);
     
}
