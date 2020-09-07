package com.hongcheng.techinnovte.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongcheng.techinnovte.entity.AppDataManageMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础数据维目录 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-13
 */
public interface AppDataManageMenuMapper extends BaseMapper<AppDataManageMenu> {
    @Select("SELECT * FROM `app_data_manage_menu` order by type_order asc, menu_level asc , menu_order asc")
    List<Map<String, Object>> getListByOrder();

    @Select("select column_name,column_comment  from information_schema.COLUMNS  where table_schema='digital_economy' and table_name =#{name} ")
    List<Map<String, Object>> getTableColumn(String name);

    @Select("select *  from digital_economy.${name}")
    IPage<Map<String, Object>> getTableData(Page<Map<String, Object>> page, String name);

    @Select("select *  from digital_economy.${name} where ${condition}")
    IPage<Map<String, Object>> getTableDataByCondition(Page<Map<String, Object>> page, String name, String condition);


    void submitAudit(String tableName, @Param(value="params") Map<String, Object> params);

//    @Insert({
//            "<script>",
//            "insert into table_name(column1, column2, column3) values ",
//            "<foreach collection='testLists' item='item' index='index' separator=','>",
//            "(#{item.实体属性1}, #{item.实体属性2}, #{item.实体属性3})",
//            "</foreach>",
//            "</script>"
//    })
//    int insertCollectList(@Param(value="testLists") List<Test> testLists);
}
