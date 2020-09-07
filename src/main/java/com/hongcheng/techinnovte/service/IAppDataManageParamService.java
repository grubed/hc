package com.hongcheng.techinnovte.service;

import com.hongcheng.techinnovte.entity.AppDataManageParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础数据维护查询入参 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
public interface IAppDataManageParamService extends IService<AppDataManageParam> {
    List<AppDataManageParam> getParam(Map<String, Object> columnMap);
}
