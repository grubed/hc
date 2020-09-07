package com.hongcheng.techinnovte.controller;


import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.pojo.dto.PermissionDTO;
import com.hongcheng.techinnovte.entity.SysPermission;
import com.hongcheng.techinnovte.service.ISysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台权限表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@RestController
@Api(tags = "权限资源")
@RequestMapping("/permission")
public class SysPermissionController {
    @Resource
    private ISysPermissionService iSysPermissionService;
    @ApiOperation("查询所有权限")
    @GetMapping("")
    public Result<List<SysPermission>> getPermission() {
        return Result.getSuccess(iSysPermissionService.getPermissions());
    }

    @ApiOperation("新建权限")
    @PostMapping("")
    public Result createPermission(@RequestBody PermissionDTO permissionDTO) {
        iSysPermissionService.createPermission(permissionDTO);
        return Result.getSuccess();
    }

    @ApiOperation("修改权限")
    @PutMapping("/{id}")
    public Result modifyPermission(@PathVariable String id, @RequestBody PermissionDTO permissionDTO) {
        iSysPermissionService.modifyPermission(id, permissionDTO);
        return Result.getSuccess();
    }

    @ApiOperation("删除权限")
    @DeleteMapping("/{id}")
    public Result deletePermission(@PathVariable String id) {
        iSysPermissionService.deletePermission(id);
        return Result.getSuccess();
    }
}
