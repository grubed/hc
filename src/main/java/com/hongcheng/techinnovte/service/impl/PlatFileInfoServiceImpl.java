package com.hongcheng.techinnovte.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hongcheng.techinnovte.common.MinioAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import com.hongcheng.techinnovte.common.exception.CommonJsonException;
import com.hongcheng.techinnovte.common.util.FileUtil;
import com.hongcheng.techinnovte.common.util.ServletUtil;
import com.hongcheng.techinnovte.entity.PlatFileInfo;
import com.hongcheng.techinnovte.mapper.PlatFileInfoMapper;
import com.hongcheng.techinnovte.service.IPlatFileInfoService;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;

import javax.annotation.Resource;

/**
 * <p>
 * 文件信息表 服务实现类
 * </p>
 *
 * @author zhoujj
 * @since 2020-07-16
 */
@Service
public class PlatFileInfoServiceImpl extends ServiceImpl<PlatFileInfoMapper, PlatFileInfo> implements IPlatFileInfoService {

	@Resource
	private MinioAutoConfiguration minioconfig;

	@Override
	public Long upload(MinioClient minioClient, String bucket, MultipartFile file) throws Exception {
		InputStream filestream = null;
		ByteArrayOutputStream stream = null;
		PlatFileInfo fileinfo = null;
		try {
			filestream = file.getInputStream(); // 得到文件流
			
			stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[10240];
			int len;
			while((len = filestream.read(buffer)) > -1) {
				stream.write(buffer, 0, len);
			}
			stream.flush();
			
			String file_originname = file.getOriginalFilename(); // 文件名
			String file_ext = FileUtil.suffix(file_originname);
			//String contentType = file.getContentType();  //类型
			String file_realname = new SimpleDateFormat("yyyyMMddkkmmss").format(new Date()) + ((int) (Math.random() * (100 - 1) + 1)) + '.' + file_ext;
			//文件信息保存到数据库
			fileinfo = new PlatFileInfo();
			fileinfo.setFileRealname(file_realname);
			fileinfo.setFileOriginname(file_originname);
			fileinfo.setFileBucket(bucket);
			fileinfo.setFileExt(file_ext);
			fileinfo.setFileMd5(FileUtil.md5(new ByteArrayInputStream(stream.toByteArray())));
			fileinfo.setFileSize(file.getSize());
			User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
			fileinfo.setCreateuserid(user.getId());
			fileinfo.setCreatedate(new Date());
			this.baseMapper.insert(fileinfo);
			//文件信息保存到对象存储服务
			
			InputStream wirteoss = new ByteArrayInputStream(stream.toByteArray());
			minioClient.putObject(bucket, file_realname, wirteoss, new PutObjectOptions(wirteoss.available(), -1)); // 把文件放置Minio桶(文件夹)
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new CommonJsonException(ErrorEnum.E_60001);
		}finally {
			filestream.close();
			stream.close();
		}
		return fileinfo.getId();
	}

	@Override
	public void downcount(Long fileid) {
		this.baseMapper.downcount(fileid);
	}

	@Override
	public Map<String, PlatFileInfo> selectByIds(String... ids) {
		Map<String, PlatFileInfo> result = new HashMap();
		
		List<String> param = new ArrayList<String>();
		for(String id : ids) {
			if(StringUtils.isNotBlank(id)) {
				param.add(id);
			}
		}
		if(param.size() == 0) {
			return result;
		}
		
		List<PlatFileInfo> list =  this.baseMapper.selectByIds(param.toArray());
		if(list.size() == 0) {
			return result;
		}
		
		for(PlatFileInfo model : list) {
			result.put(model.getId().toString(), model);
		}
		return result;
	}

	public PlatFileInfo selectById(String id) {
		return this.baseMapper.selectById(id);
	}

	public String getUrl(String fileid) {
		try {
			MinioClient minioClient = minioconfig.minioClient();
			PlatFileInfo file = getById(fileid);
			return minioClient.presignedGetObject(file.getFileBucket(), file.getFileRealname());
		} catch (Exception e) {
			return null;
		}
	}
}