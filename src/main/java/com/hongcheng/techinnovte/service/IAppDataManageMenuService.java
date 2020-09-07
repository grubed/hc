package com.hongcheng.techinnovte.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongcheng.techinnovte.pojo.dto.AddDataDTO;
import com.hongcheng.techinnovte.pojo.dto.InputConditionDTO;
import com.hongcheng.techinnovte.pojo.dto.MenuDTO;
import com.hongcheng.techinnovte.entity.AppDataManageMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础数据维目录 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
public interface IAppDataManageMenuService extends IService<AppDataManageMenu> {

    List<MenuDTO> getMenu();
     List<Map<String, Object>> getTableColumn(String name) ;
    IPage<Map<String, Object>> getTableData(Page<Map<String, Object>> page, String name);
    IPage<Map<String, Object>> getTableData(Page<Map<String, Object>> page, String name, List<InputConditionDTO> condition) ;
    Boolean setTableData(AddDataDTO addDataDTO);
    void newMenu();
    void modifyMenu();
}
