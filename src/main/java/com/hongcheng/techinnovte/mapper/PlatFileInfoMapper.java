package com.hongcheng.techinnovte.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongcheng.techinnovte.entity.PlatFileInfo;

/**
 * <p>
 * 文件信息表 Mapper 接口
 * </p>
 *
 * @author zhoujj
 * @since 2020-07-16
 */
public interface PlatFileInfoMapper extends BaseMapper<PlatFileInfo> {

	void downcount(@Param("fileid")Long fileid);
	
	List<PlatFileInfo> selectByIds(Object[] ids);
	
}
