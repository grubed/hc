package com.hongcheng.techinnovte.controller;


import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import com.hongcheng.techinnovte.pojo.dto.*;
import com.hongcheng.techinnovte.common.exception.OldPasswordErrorException;
import com.hongcheng.techinnovte.common.exception.RedisKeyFaileException;
import com.hongcheng.techinnovte.common.util.ServletUtil;
import com.hongcheng.techinnovte.common.util.ValidateCodeUtil;
import com.hongcheng.techinnovte.entity.SysUser;
import com.hongcheng.techinnovte.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 运营后台用户表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Slf4j
@RestController
//@RequestMapping("")
@Api(tags = "用户和登录模块")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;
    /**
     * 登录
     */
    @ApiOperation("短信登陆")
    @PostMapping("/loginSMSRand")
    public Result<TokenInfoDTO> loginSMSRand(@RequestBody SMSLoginDTO requestJson) {

        return Result.getSuccess(iSysUserService.smsLogin(requestJson));
    }

    @ApiOperation("登入认证")
    @PostMapping("/login")
    public Result<TokenInfoDTO> authLogin(@RequestBody LoginDTO requestJson) {
        TokenInfoDTO info = iSysUserService.authLogin(requestJson);
        return Result.getSuccess(info);
    }

    //返回验证码图片
    @ApiOperation("图片验证码")
    @GetMapping("/captchaImg")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            // getRandomCodeImage方法会直接将生成的验证码图片写入response
            validateCode.getRandomCodeImage(request, response);
            // System.out.println("session里面存储的验证码为："+session.getAttribute("JCCODE"));
            log.info(session.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @ApiOperation("验证图片验证码")
    @GetMapping("/checkCaptcha")
    public Result getCheckCaptcha(@RequestParam("code") String code, HttpSession session) {

        try {
            log.info(session.getId());
            //toLowerCase() 不区分大小写进行验证码校验
            String sessionCode = String.valueOf(session.getAttribute("JCCODE")).toLowerCase();
            log.info("session里的验证码：" + sessionCode);
            String receivedCode = code.toLowerCase();
            log.info("用户的验证码：" + receivedCode);

            if(!sessionCode.equals("") && !receivedCode.equals("") && sessionCode.equals(receivedCode)) {
                return Result.getSuccess("验证成功");
            } else {
                return Result.getFail("验证失败");
            }
        } catch (Exception e) {
            return Result.getFail("验证失败");
        }

    }
//    @ApiOperation("获取验证码")
//    @GetMapping("/smsrand")
//    public Result<JSONObject> getSMSRand(@RequestBody LoginDTO requestJson) {
//        iSysUserService.sms();
//        return Result.getSuccess();
//    }

    @ApiOperation("验证短信验证码")
    @PostMapping("/valicode")
    public Result<JSONObject> validateCode(@RequestBody ValicodeDTO valicodeDTO) {
        try {
            Boolean b = iSysUserService.verCode(valicodeDTO.getMobile(), valicodeDTO.getCode());
            if(b ==Boolean.FALSE) {
                return Result.getFail("短信验证码错误");
            }
        } catch (RedisKeyFaileException e) {
            return Result.getFail("短信验证码过期或已验证");
        }
        return Result.getSuccess();
    }
    /**
     * 查询当前登录用户的信息
     */
    @ApiOperation("查询当前登录用户的信息")
    @GetMapping("/user/{id}/info")
    // @RequiresPermissions("userinfo:get")
    public Result<User> getInfo() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String username = request.getSession().getAttribute("username").toString();

        User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
        return Result.getSuccess(iSysUserService.getInfo(user.getUsername()));
    }
    @ApiOperation("刷新令牌")
    @GetMapping("/refreshToken")
    public Result<String> refreshToken(@RequestParam String token) {
        return Result.getSuccess(iSysUserService.refreshToken(token));
    }

    /**
     * 登出
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result logout() {

        iSysUserService.logout();
        return Result.getSuccess();
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/users")
    public Result<List<UserRoleDTO>> getUsers() {
        return Result.getSuccess(iSysUserService.getUsers());
    }

    @ApiOperation("注册用户")
    @PostMapping("/user")
    public Result createUser(@RequestBody UserDTO userDTO) {
        try {
            Boolean b = iSysUserService.verCode(userDTO.getMobile(), userDTO.getCode());
            if(b ==Boolean.FALSE) {
                return Result.getFail("短信验证码错误");
            }
        } catch (RedisKeyFaileException e) {
            return Result.getFail("短信验证码过期或已验证");
        }
        try {
            iSysUserService.createUser(userDTO);
        } catch (DuplicateKeyException e) {
            log.info(e.getMessage());
            return Result.getFail(ErrorEnum.E_10009);
        }
        return Result.getSuccess();
    }

    @ApiOperation("发送验证码")
    @PostMapping("/sms")
    public Result sms(@RequestBody MobileCodeDTO mobileCodeDTO) {
        try {
            iSysUserService.sms(mobileCodeDTO.getMobile());
        } catch (JDOMException ej) {
            Result.getFail(ej.getMessage());
        } catch (IOException eio) {
            Result.getFail(eio.getMessage());
        }
        return Result.getSuccess();
    }

    @ApiOperation("修改密码")
    @PostMapping("/resetpassword")
    public Result modifyPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
        try {
            iSysUserService.modifyPassword(user.getId().toString(), resetPasswordDTO);
        } catch (OldPasswordErrorException e) {
            return Result.getFail(e.getMsg());
        }
        return Result.getSuccess();
    }

    @ApiOperation("修改用户")
    @PostMapping("/user/{id}")
    public Result<SysUser> modifyUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        return Result.getSuccess(iSysUserService.modifyUser(id, userDTO));
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable String id) {
        iSysUserService.deleteUser(id);
        return Result.getSuccess();
    }


}
