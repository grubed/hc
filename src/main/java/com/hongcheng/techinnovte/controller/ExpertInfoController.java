package com.hongcheng.techinnovte.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.Pagination;
import com.hongcheng.techinnovte.common.util.ServletUtil;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.pojo.dto.ExpertInfoDTO;
import com.hongcheng.techinnovte.pojo.vo.ExpertInfoVO;
import com.hongcheng.techinnovte.pojo.vo.HumanInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sj
 * @since 2020-07-31
 */
@RestController
@Slf4j
@RequestMapping("/expertInfo")
@Api(tags="专家信息")
public class ExpertInfoController extends BaseCustomCrudRestController<ExpertInfo> {
    @Autowired
    private IExpertApplyService  iExpertApplyService;

    @Autowired
    private ExpertInfoDiService expertInfoDiService;

    @Autowired
    private HumanInfoDiService humanInfoDiService;

    @ApiOperation(value = "专家信息查询", response = ExpertInfoVO.class)
    @GetMapping("/list")
    public JsonResult searchExpertInfo(ExpertInfoDTO expertInfoDTO, Pagination pagination) throws Exception {
        User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
        QueryWrapper<ExpertInfoDTO> queryWrapper = super.buildQueryWrapper(expertInfoDTO);
        if(user != null && (user.getRoles().contains("msc") || user.getRoles().contains("zgjg") || user.getRoles().contains("admin")) ){

        } else if(user != null){
            QueryWrapper<ExpertApply> wrapper = new QueryWrapper<>();
            wrapper.eq("USER_ID", user.getId());
            ExpertApply expertApply = iExpertApplyService.getOne(wrapper);
            queryWrapper.lambda().eq(ExpertInfoDTO::getApplyExpertId, expertApply.getId());
        }
        List entityList = this.getService().getViewObjectList(queryWrapper, pagination, ExpertInfoVO.class);
        // JsonResult jsonResult = super.getViewObjectList(queryWrapper, pagination, AllianceMemberVO.class);
        return JsonResult.OK(entityList).bindPagination(pagination);
        // return super.getViewObjectList(expertInfoDTO, pagination, ExpertInfoVO.class);
    }

    @ApiOperation(value = "查看某个专家信息",response = ExpertInfoVO.class)
    @GetMapping("/{id}")
    public JsonResult getExpertInfo(@PathVariable String id) throws Exception {

        ExpertInfoVO expertInfoVO = (ExpertInfoVO)super.getViewObject(id, ExpertInfoVO.class).getData();
        if(expertInfoVO == null) {
            return JsonResult.FAIL_INVALID_PARAM("未找到专家");
        }
        HumanInfoVO humanInfoVO = humanInfoDiService.getViewObject(expertInfoVO.getHumanId(), HumanInfoVO.class);
        expertInfoVO.setHumanInfoVO(humanInfoVO);
        return JsonResult.OK(expertInfoVO);
    }

    @ApiOperation(value = "修改专家信息查询", response = ExpertInfo.class)
    @PutMapping("/{id}")
    public JsonResult putExpertInfo(@PathVariable String id, @RequestBody ExpertInfo expertInfo)throws Exception {

        return super.updateEntity(id, expertInfo);
    }
}
