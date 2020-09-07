package com.hongcheng.techinnovte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import com.hongcheng.techinnovte.pojo.dto.*;
import com.hongcheng.techinnovte.common.enumeration.LetterType;
import com.hongcheng.techinnovte.common.exception.CommonJsonException;
import com.hongcheng.techinnovte.common.exception.OldPasswordErrorException;
import com.hongcheng.techinnovte.common.exception.RedisKeyFaileException;
import com.hongcheng.techinnovte.common.plus.VerificationCode;
import com.hongcheng.techinnovte.common.util.*;
import com.hongcheng.techinnovte.entity.*;
import com.hongcheng.techinnovte.mapper.SysRolePermissionMapper;
import com.hongcheng.techinnovte.mapper.SysUserMapper;
import com.hongcheng.techinnovte.mapper.SysUserRoleMapper;
import com.hongcheng.techinnovte.service.ISysPermissionService;
import com.hongcheng.techinnovte.service.ISysRoleService;
import com.hongcheng.techinnovte.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jdom.JDOMException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 运营后台用户表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    protected StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ISysPermissionService iSysPermissionService;
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Resource
    private VerificationCode verificationCode;

    @Resource
    private ISysRoleService iSysRoleService;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private LhzxCustBaseMapper lhzxCustBaseMapper;
    /**
     * 登录表单提交
     * @param jsonObject
     */
    @Override
    public TokenInfoDTO authLogin(LoginDTO jsonObject) throws CommonJsonException {
        String username = jsonObject.getMobile();
        String password = jsonObject.getPassword();

        SysUser sysUser = this.baseMapper.getUser(username, password);
        if(sysUser == null) {
            throw new CommonJsonException(ErrorEnum.E_10001);
        }
        User user = getInfo(username);
        // JSONObject info = new JSONObject();
        TokenInfoDTO info = new TokenInfoDTO();
        String token = JWTUtil.createToken(user);
        info.setToken(token);
        //info.put("token",token);
        info.setUser(user);
        //info.put("user",user);
        String refreshToken = JWTUtil.createToken(username);
        info.setRefreshToken(refreshToken);
        //info.put("refreshToken",refreshToken);
        return info;
    }
    @Override
    public TokenInfoDTO smsLogin(SMSLoginDTO jsonObject) throws CommonJsonException {
        String username = jsonObject.getMobile();
        String code = jsonObject.getCode();
        try {
            Boolean b = verCode(username, code);
            if(b == false) {
                throw new CommonJsonException(ErrorEnum.E_10002);
            }
        } catch ( RedisKeyFaileException e) {
            throw new CommonJsonException(ErrorEnum.E_10002);
        }
        SysUser sysUser = this.baseMapper.getUserByUsername(username);
        if(sysUser == null) {
            throw new CommonJsonException(ErrorEnum.E_10002);
        }
        User user = getInfo(username);
        // JSONObject info = new JSONObject();
        TokenInfoDTO info = new TokenInfoDTO();
        String token = JWTUtil.createToken(user);
        info.setToken(token);
        //info.put("token",token);
        info.setUser(user);
        //info.put("user",user);
        String refreshToken = JWTUtil.createToken(username);
        info.setRefreshToken(refreshToken);
        //info.put("refreshToken",refreshToken);
        return info;
    }
    @Override
    public String refreshToken(String refreshToken) throws CommonJsonException {
        String username = JWTUtil.getUsername(refreshToken);
        if(JWTUtil.refreshTokenVerify(refreshToken, username) == false) {
            throw new CommonJsonException(ErrorEnum.E_10001);
        }
        User user = getInfo(username);

        String token = JWTUtil.createToken(user);
        return token;
    }
    /**
     * 根据用户名和密码查询对应的用户
     */
    @Override
    public JSONObject getUser(String username, String password) {

        return JSONObject.parseObject(JSON.toJSONString(this.baseMapper.getUser(username, password)));
    }

    /**
     * 查询当前登录用户的权限等信息
     */
    @Override
    public User getInfo(String username) {
        //从session获取用户信息

//        Session session = SecurityUtils.getSubject().getSession();
//        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
//        if(userInfo == null) {
//            // return CommonUtil.errorJson(ErrorEnum.E_20011);
//        }
//        String username = userInfo.getString("username");
//
//        JSONObject info = new JSONObject();
//        JSONObject userPermission = iSysPermissionService.getUserPermission(username);
//        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
//        info.put("userPermission", userPermission);
        Long userId = this.baseMapper.getUserIdByUsername(username);
        Set<String> roleCodes = userRoleMapper.getRoleCodes(userId.toString());
        Set<Integer> roleIds = userRoleMapper.getRoleIds(userId.toString());
        Set<String> permissions = null;
        if(roleIds.size() > 0) {
            permissions = sysRolePermissionMapper.getRolePermissions(new ArrayList<Integer>(roleIds));
        } else {
            permissions = new HashSet<>();
        }

        JSONObject info = new JSONObject();
        User user = new User();
        SysUser sysUser = getById(userId);
        user.setId(userId);
        user.setUsername(username);
        user.setUser(sysUser);
        if(roleCodes.size() == 0) {
            roleCodes.add("user");
        }
        user.setRoles(roleCodes);
        user.setPermissions(permissions);
        return user;
    }

    /**
     * 退出登录
     */
    @Override
    public void logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return ;
    }

    public List<UserRoleDTO> getUsers() {
        return this.baseMapper.getUsers();
    }
    public Long getMscId(){
        SysUser sysUser = this.baseMapper.getRoleUser("msc");
        return sysUser.getId();
    }
    public void createUser(UserDTO userDTO){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDTO, sysUser);
        sysUser.setUsername(userDTO.getMobile());

//        LhzxCustBase lhzxCustBase = new LhzxCustBase();
//        lhzxCustBase.setCustname("");
//        lhzxCustBase.setEnabled(0);
//        lhzxCustBaseMapper.insert(lhzxCustBase);
        //sysUser.setCustId(lhzxCustBase.getId());

        this.baseMapper.insert(sysUser);
//        SysUserRole sysUserRole = new SysUserRole();
//        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(SysRole::getRoleCode, "user");
//        SysRole sysRole = iSysRoleService.getOne(queryWrapper);
//        sysUserRole.setUserId(sysUser.getId());
//        sysUserRole.setRoleId(sysRole.getId());
//        sysUserRoleMapper.insert(sysUserRole);
    }
    public SysUser modifyUser(String id, UserDTO userDTO)
    {
        SysUser sysUser = this.baseMapper.selectById(id);
        BeanUtils.copyProperties(userDTO, sysUser, CommonUtil.getNullPropertyNames(userDTO));
        this.baseMapper.updateById(sysUser);
        User user = (User) ServletUtil.getCurrentRequest().getAttribute("user");
        user.setUser(sysUser);
        ServletUtil.getCurrentRequest().setAttribute("user", user);
        return sysUser;
    }
    public void modifyPassword(String id, ResetPasswordDTO resetPasswordDTO) throws OldPasswordErrorException {

        SysUser sysUser = this.baseMapper.selectById(id);
        sysUser.setPassword(resetPasswordDTO.getNewPassword());
        this.baseMapper.updateById(sysUser);
//        if(sysUser.getPassword().equals(resetPasswordDTO.getOldPassword())) {
//
//        } else {
//            throw new OldPasswordErrorException();
//        }
    }
    public void deleteUser(String id)
    {
        this.baseMapper.deleteById(id);
    }

    public void sms(String mobile) throws JDOMException, IOException {
        String code = SmsUtil.buildRandom(4);
        verificationCode.set(mobile, code);
        SmsUtil.SmsSend(LetterType.VALID, mobile, code);
    }
    public Boolean verCode(String mobile, String code) throws RedisKeyFaileException {
        String redisCode = verificationCode.get(mobile);
        if(redisCode.equals(code)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
