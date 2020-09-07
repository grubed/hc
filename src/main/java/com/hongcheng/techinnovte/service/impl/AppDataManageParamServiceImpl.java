package com.hongcheng.techinnovte.service.impl;

import com.hongcheng.techinnovte.entity.AppDataManageParam;
import com.hongcheng.techinnovte.mapper.AppDataManageParamMapper;
import com.hongcheng.techinnovte.service.IAppDataManageParamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础数据维护查询入参 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
@Service
public class AppDataManageParamServiceImpl extends ServiceImpl<AppDataManageParamMapper, AppDataManageParam> implements IAppDataManageParamService {
    public List<AppDataManageParam> getParam(Map<String, Object> columnMap) {
        return this.listByMap(columnMap);
    }
}
