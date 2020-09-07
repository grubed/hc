package com.hongcheng.techinnovte.controller;


import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.pojo.dto.RoleDTO;
import com.hongcheng.techinnovte.entity.SysRole;
import com.hongcheng.techinnovte.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台角色表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Api(tags = "角色")
@RestController
@RequestMapping("/role")
public class SysRoleController {
    @Resource
    private ISysRoleService iSysRoleService;

    @ApiOperation("查询所有角色")
    @GetMapping("")
    public Result<List<SysRole>> getRoles() {
        return Result.getSuccess(iSysRoleService.getRoles());
    }

    @ApiOperation("创建角色")
    @PostMapping("")
    public Result createRole(@RequestBody RoleDTO roleDTO) {
        iSysRoleService.createRole(roleDTO);
        return Result.getSuccess();
    }

    @ApiOperation("修改角色")
    @PutMapping("/{id}")
    public Result modifyRole(@PathVariable String id,@RequestBody RoleDTO roleDTO) {
        iSysRoleService.modifyRole(id,roleDTO);
        return Result.getSuccess();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public Result deleteRole(@PathVariable String id) {
        iSysRoleService.deleteRole(id);
        return Result.getSuccess();
    }
}
