package com.hongcheng.techinnovte.controller;

import com.diboot.core.vo.JsonResult;
import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.pojo.dto.MtDTO;
import com.hongcheng.techinnovte.common.util.ServletUtil;
import com.hongcheng.techinnovte.common.util.XMLUtil;
import com.hongcheng.techinnovte.service.DrlTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.jdom.JDOMException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Slf4j
@RestController
public class TestController {
    @Resource
    private DrlTestService drlTestService;

    @GetMapping("/test")
    public JsonResult test() throws JDOMException, IOException {
        JsonResult jsonResult = new JsonResult(-1, "", null);
        return jsonResult.msg("推荐单位重复：");
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public Result unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        log.info(message);
        return Result.getFail(401, message);
    }
    @GetMapping("/testUser")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public Result user() {
        User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
        return Result.getSuccess(user);
    }



}
