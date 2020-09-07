package com.hongcheng.techinnovte.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongcheng.techinnovte.entity.PlatFileInfo;

import io.minio.MinioClient;

/**
 * <p>
 * 文件信息表 服务类
 * </p>
 *
 * @author zhoujj
 * @since 2020-07-16
 */
public interface IPlatFileInfoService extends IService<PlatFileInfo> {
	
	/**
	 * 文件上传接口
	 * @param minioClient
	 * @param bucket
	 * @param file
	 * @return
	 * @throws Exception
	 */
	Long upload(MinioClient minioClient, String bucket, MultipartFile file) throws Exception;
	
	/**
	 * 文件下载次数更新接口
	 * @param fileid
	 */
	void downcount(Long fileid);
	
	/**
	 * 根据id获取文件对象
	 * @param id
	 * @return
	 */
	Map<String, PlatFileInfo> selectByIds(String... ids);
	PlatFileInfo selectById(String id);
	String getUrl(String fileid);
}
