package com.hongcheng.techinnovte.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hongcheng.techinnovte.common.MinioAutoConfiguration;
import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.common.util.ExportUtil;
import com.hongcheng.techinnovte.entity.PlatFileInfo;
import com.hongcheng.techinnovte.service.IPlatFileInfoService;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 * 文件信息表 前端控制器
 * </p>
 *
 * @author zhoujj
 * @since 2020-07-16
 */
@Slf4j
@RestController
@Api(tags = "文件信息管理")
@RequestMapping("/file")
public class PlatFileInfoController {
	
	@Resource
	private MinioAutoConfiguration minioconfig;

	@Autowired
	private IPlatFileInfoService fileService;
	
	@ApiIgnore
	@Deprecated
	@GetMapping("/init")
	public Result<String> init() {
		File ufile = null;
		try {
			MinioClient minioClient = minioconfig.minioClient();
			File dir = new File("/data/tomcat/80/webapps/ROOT/upload");
			File[] files = dir.listFiles();
			for(File f : files) {
				ufile = f;
				if(f.isFile()) {
					InputStream filestream = new FileInputStream(f);
					String file_realname = f.getName();
					minioClient.putObject("itais", file_realname, filestream, new PutObjectOptions(filestream.available(), -1)); // 把文件放置Minio桶(文件夹)
				}
				Thread.sleep(300);
			}
			return Result.getSuccess("初始化结束");
		} catch (Exception e) {
			return Result.getFail(ufile.getName() + " [上传异常] " + e.getMessage());
		}
	}
	
	@ApiOperation("文件上传")
	@PostMapping("/upload")
	public Result<String> upload(@ApiParam(name = "files", value = "文件", required = true) MultipartFile[] files) {
		try {
			MinioClient minioClient = minioconfig.minioClient();
			StringBuilder fileids = new StringBuilder();
			for (MultipartFile file : files) {
				if (fileids.length() > 0) {
					fileids.append(',');
				}
				fileids.append(fileService.upload(minioClient, minioconfig.getBucketName(), file));
			}
			return Result.getSuccess(fileids);
		} catch (Exception e) {
			return Result.getFail(e.getMessage());
		}
	}

	/**
	 * 下载minio服务的文件
	 * @param fileid
	 * @param response
	 * @return
	 */
	@ApiOperation("附件下载")
	@GetMapping("/download")
	//@GetMapping("/download/{fileid}")  @PathVariable(value="fileid", required=true) String fileid, 
	public String download(@ApiParam(name = "fileid", value = "文件名", required = true) String fileid, HttpServletRequest request, HttpServletResponse response) {
		InputStream fileInputStream = null;
		OutputStream fileOutputStream = null;
		try {
			//MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
			MinioClient minioClient = minioconfig.minioClient();
			PlatFileInfo file = fileService.getById(fileid);
			fileInputStream = minioClient.getObject(file.getFileBucket(), file.getFileRealname());
			ExportUtil.resHeader(request, response, file.getFileOriginname());
			fileOutputStream = response.getOutputStream();
			IOUtils.copy(fileInputStream, fileOutputStream);
			fileService.downcount(Long.valueOf(fileid));//更新下载次数
			return "附件下载成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "附件下载成功";
		} finally {
			try {
				fileInputStream.close();
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取minio文件的下载地址
	 * @param fileid
	 * @return
	 */
	@ApiOperation("获取文件的下载地址")
	@GetMapping("/url")
	public Result<String> getUrl(@ApiParam(name = "fileid", value = "文件名", required = true) String fileid) {
		try {
			//MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
			MinioClient minioClient = minioconfig.minioClient();
			PlatFileInfo file = fileService.getById(fileid);
			String url = minioClient.presignedGetObject(file.getFileBucket(), file.getFileRealname());
			return Result.getSuccess(url);
		} catch (Exception e) {
			return Result.getFail("获取失败");
		}
	}
}
