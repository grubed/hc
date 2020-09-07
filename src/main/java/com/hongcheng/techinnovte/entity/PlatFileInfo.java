package com.hongcheng.techinnovte.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author zhoujj
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PlatFileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    
    /**
     * 文件名称
     */
    @TableField("FILE_REALNAME")
    @JsonProperty("file_realname")
    private String fileRealname;

    /**
     * 文件原名称
     */
    @TableField("FILE_ORIGINNAME")
    @JsonProperty("file_originname")
    private String fileOriginname;

    /**
     * 文件属桶
     */
    @TableField("FILE_BUCKET")
    @JsonProperty("file_bucket")
    private String fileBucket;

    /**
     * 文件扩展名
     */
    @TableField("FILE_EXT")
    @JsonProperty("file_ext")
    private String fileExt;

    /**
     * 文件MD5码
     */
    @TableField("FILE_MD5")
    @JsonProperty("file_md5")
    private String fileMd5;

    /**
     * 文件大小
     */
    @TableField("FILE_SIZE")
    @JsonProperty("file_size")
    private Long fileSize;

    /**
     * 文件下载次数
     */
    @TableField("FILE_DOWNCOUNT")
    @JsonProperty("file_downcount")
    private Integer fileDowncount;

    /**
     * 文件描述
     */
    @TableField("FILE_DESC")
    @JsonProperty("file_desc")
    private String fileDesc;

    /**
     * 是否有效
     */

    @TableField("ENABLED")
    private Integer enabled;

    /**
     * 创建时间
     */
    @TableField("CREATEDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    /**
     * 创建人
     */
    @TableField("CREATEUSERID")
    private Long createuserid;

    /**
     * 更新时间
     */
    @TableField("UPDATEDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedate;

    /**
     * 更新人
     */
    @TableField("UPDATEUSERID")
    private Long updateuserid;


}
