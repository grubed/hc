package com.hongcheng.techinnovte.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongcheng.techinnovte.pojo.dto.AddDataDTO;
import com.hongcheng.techinnovte.pojo.dto.InputConditionDTO;
import com.hongcheng.techinnovte.pojo.dto.MenuDTO;
import com.hongcheng.techinnovte.entity.AppDataManageMenu;
import com.hongcheng.techinnovte.mapper.AppDataManageMenuMapper;
import com.hongcheng.techinnovte.service.IAppDataManageMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 基础数据维目录 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
@Service
public class AppDataManageMenuServiceImpl extends ServiceImpl<AppDataManageMenuMapper, AppDataManageMenu> implements IAppDataManageMenuService {


    public List<MenuDTO> getMenu() {
        List<MenuDTO> result = new ArrayList<>();

        List<Map<String, Object>> map =  this.getBaseMapper().getListByOrder();
        for (Map<String, Object> m : map) {
            if(m.get("par_id") == null) {
                MenuDTO menuDTO = getNewMenuDTO(m);
//                MenuDTO menuDTO = new MenuDTO();
//                menuDTO.setId((int)m.get("id"));
//                menuDTO.setName("");
//                menuDTO.setLevel((int)m.get("menu_level"));
//                if (m.get("icon") != null) {
//                    menuDTO.setIcon(m.get("icon").toString());
//                }
//                menuDTO.setText(m.get("menu_name").toString());
                result.add(menuDTO);

            } else {
                Integer level = (int)m.get("menu_level");
                MenuDTO current = getCurrnetMenu(result, level);
                MenuDTO menuDTO = getNewMenuDTO(m);
                if(current.getChildren() == null) {
                    current.setChildren(new ArrayList<>());
                }
                current.getChildren().add(menuDTO);
            }
        }
        return result;
    }

    private MenuDTO getNewMenuDTO(Map<String, Object> m) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId((int)m.get("id"));
        if(m.get("par_id") != null) {
            menuDTO.setName(m.get("target_table").toString());
        }
        if(m.get("par_id") != null) {
            menuDTO.setFarId((int) m.get("par_id"));
        }
        menuDTO.setLevel((int)m.get("menu_level"));
        if (m.get("icon") != null) {
            menuDTO.setIcon(m.get("icon").toString());
        }
        menuDTO.setText(m.get("menu_name").toString());

        return menuDTO;
    }

    private MenuDTO getCurrnetMenu(List<MenuDTO> result, Integer level) {
        MenuDTO current = null;
        for(int i = 1; i < level; i++) {
            if(i == 1) {
                current = result.get(result.size() - 1);
            } else {
                current = current.getChildren().get(current.getChildren().size() - 1);
            }
        }
        return current;
    }

    public void newMenu(){

    }
    public void modifyMenu(){

    }
    public List<Map<String, Object>> getTableColumn(String name) {
        return this.getBaseMapper().getTableColumn(name);
    }
    public IPage<Map<String, Object>> getTableData(Page<Map<String, Object>> page, String name) {
        return this.getBaseMapper().getTableData(page, name);
    }

    public IPage<Map<String, Object>> getTableData(Page<Map<String, Object>> page, String name, List<InputConditionDTO> condition) {
        StringBuilder cond = new StringBuilder();
        for (InputConditionDTO inputConditionDTO:condition) {
            if(inputConditionDTO.getLogic() != null) {
                cond.append(' '+inputConditionDTO.getLogic()+' ');
            }
            if(inputConditionDTO.getTable() != null) {
                cond.append(inputConditionDTO.getTable() + '.');
            }
            cond.append(inputConditionDTO.getKind());
            cond.append(' '+inputConditionDTO.getRule()+' ');
            if(inputConditionDTO.getRule().equals("LIKE")) {
                cond.append("'"+inputConditionDTO.getValue()+"%'");
            } else {
                cond.append("'"+inputConditionDTO.getValue()+"'");
            }
        }
        if(cond.length() == 0) {
            return this.getBaseMapper().getTableData(page, name);
        } else {
            return this.getBaseMapper().getTableDataByCondition(page, name, cond.toString());
        }
    }

    public Boolean setTableData(AddDataDTO addDataDTO) {
        this.getBaseMapper().submitAudit(addDataDTO.getTableName(), addDataDTO.getData());
        return Boolean.TRUE;
    }
}
