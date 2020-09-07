package com.hongcheng.techinnovte.common.shiro;

import com.hongcheng.techinnovte.pojo.bean.User;
import com.hongcheng.techinnovte.common.util.JWTUtil;
import com.hongcheng.techinnovte.common.util.ServletUtil;
import com.hongcheng.techinnovte.entity.SysUser;
import com.hongcheng.techinnovte.mapper.SysRolePermissionMapper;
import com.hongcheng.techinnovte.mapper.SysUserMapper;
import com.hongcheng.techinnovte.mapper.SysUserRoleMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author: hxy
 * @description: 自定义Realm
 * @date: 2017/10/24 10:06
 */
public class UserRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private SysUserMapper userMapper;

	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Autowired
	private SysRolePermissionMapper  sysRolePermissionMapper;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}
//	@Override
//	@SuppressWarnings("unchecked")
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		Session session = SecurityUtils.getSubject().getSession();
//		//查询用户的权限
//		JSONObject permission = (JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
//		logger.info("permission的值为:" + permission);
//		logger.info("本用户权限为:" + permission.get("permissionList"));
//		//为当前用户设置角色和权限
//		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.addStringPermissions((Collection<String>) permission.get("permissionList"));
//		return authorizationInfo;
//	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("————权限认证————");
		String username = JWTUtil.getUsername(principals.toString());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获得该用户角色
		String userId = userMapper.getUserIdByUsername(username).toString();
		//每个角色拥有默认的权限
		Set<String> roleCodes = userRoleMapper.getRoleCodes(userId);
		Set<Integer> roleIds = userRoleMapper.getRoleIds(userId);
		Set<String> permissions = sysRolePermissionMapper.getRolePermissions(new ArrayList<Integer>(roleIds));
		//设置该用户拥有的角色和权限
		info.setRoles(roleCodes);
		info.setStringPermissions(permissions);
		return info;
	}
	/**
	 * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("————身份认证方法————");
		String token = (String) authenticationToken.getCredentials();
		// 解密获得username，用于和数据库进行对比
		String username = JWTUtil.getUsername(token);
		if (username == null || !JWTUtil.verify(token, username)) {
			throw new AuthenticationException("登录已过期，请重新登录");
		}
//		String password = userMapper.getPassword(username);
//		if (password == null) {
//			throw new AuthenticationException("该用户不存在！");
//		}
//		int ban = userMapper.checkUserBanStatus(username);
//		if (ban == 1) {
//			throw new AuthenticationException("该用户已被封号！");
//		}

		User user = JWTUtil.getUser(token);
		SysUser sysUser = userMapper.selectById(user.getId());
		user.setUser(sysUser);
		ServletUtil.getCurrentRequest().setAttribute("user", user);

		return new SimpleAuthenticationInfo(token, token, "UserRealm");
	}
	/**
	 * 验证当前登录的Subject
	 * LoginController.login()方法中执行Subject.login()时 执行此方法
	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//		String loginName = (String) authcToken.getPrincipal();
//		// 获取用户密码
//		String password = new String((char[]) authcToken.getCredentials());
//		JSONObject user = iSysUserService.getUser(loginName, password);
//		if (user == null) {
//			//没找到帐号
//			throw new UnknownAccountException();
//		}
//		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
//		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
////				loginName,
////				password,
//				user.getString("username"),
//				user.getString("password"),
//				//ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
//				getName()
//		);
//		//session中不需要保存密码
//		user.remove("password");
//		//将用户信息放入session中
//		SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
//		return authenticationInfo;
//	}
}
