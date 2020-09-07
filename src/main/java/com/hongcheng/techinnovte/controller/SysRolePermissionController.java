package com.hongcheng.techinnovte.controller;


import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.pojo.dto.NewRolePermissionDTO;
import com.hongcheng.techinnovte.pojo.dto.RolePermissionDTO;
import com.hongcheng.techinnovte.service.ISysRolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色-权限关联表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@RestController
@Api(tags = "角色和权限关系")
@RequestMapping("/rolepermission")
public class SysRolePermissionController {

    @Resource
    private ISysRolePermissionService iSysRolePermissionService;

    @ApiOperation("查询所有角色权限")
    @GetMapping("")
    public Result<List<RolePermissionDTO>> getRolePermission() {
        return Result.getSuccess(iSysRolePermissionService.getRolePermission());
    }
    @ApiOperation("创建角色权限")
    @PostMapping("")
    public Result createRolePermission(@RequestBody NewRolePermissionDTO newRolePermissionDTO) {
        boolean b = iSysRolePermissionService.create(newRolePermissionDTO.getRoleId(), newRolePermissionDTO.getPermissionId());
        if(b == false) {
            return Result.getFail(-1, "已存在");
        }
        return Result.getSuccess();
    }

//    @ApiOperation("修改角色权限")
//    @PutMapping("/{id}")
//    public Result modifyRolePermission() {
//        return Result.getSuccess();
//    }

    @ApiOperation("删除角色权限")
    @DeleteMapping("/{id}")
    public Result deleteRolePermission() {
        return Result.getSuccess();
    }
}
