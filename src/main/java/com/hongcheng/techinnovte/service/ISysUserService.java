package com.hongcheng.techinnovte.service;

import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.pojo.dto.*;
import com.hongcheng.techinnovte.common.exception.OldPasswordErrorException;
import com.hongcheng.techinnovte.common.exception.RedisKeyFaileException;
import com.hongcheng.techinnovte.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 运营后台用户表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
public interface ISysUserService extends IService<SysUser> {
    public TokenInfoDTO authLogin(LoginDTO jsonObject);
    TokenInfoDTO smsLogin(SMSLoginDTO jsonObject);
    String refreshToken(String refreshToken);
    /**
     * 根据用户名和密码查询对应的用户
     */

    public JSONObject getUser(String username, String password);

    /**
     * 查询当前登录用户的权限等信息
     */

    public User getInfo(String username);

    /**
     * 退出登录
     */
    Long getMscId();
    public void logout() ;

    void sms(String mobile) throws JDOMException, IOException;

    Boolean verCode(String mobile, String code) throws RedisKeyFaileException;

    public List<UserRoleDTO> getUsers() ;
    public void createUser(UserDTO userDTO);
    public SysUser modifyUser(String id, UserDTO userDTO);
    void modifyPassword(String id, ResetPasswordDTO resetPasswordDTO) throws OldPasswordErrorException;
    void deleteUser(String id);
}
