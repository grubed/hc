package com.hongcheng.techinnovte.common.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: hxy
 * @description: shiro配置类
 * @date: 2017/10/24 10:10
 */
@Configuration
public class ShiroConfiguration {
	/**
	 * Shiro的Web过滤器Factory 命名:shiroFilter
	 */
//	@Bean(name = "shiroFilter")
//	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		//Shiro的核心安全接口,这个属性是必须的
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		Map<String, Filter> filterMap = new LinkedHashMap<>();
//		filterMap.put("jwt", new JWTFilter());
//
//		// filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
//		shiroFilterFactoryBean.setFilters(filterMap);
//		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized/401");
//		/*定义shiro过滤链  Map结构
//		 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
//		 * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
//		 * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
//		 */
//		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//		filterChainDefinitionMap.put("/**", "jwt");
//         /* 过滤链定义，从上向下顺序执行，一般将 / ** 放在最为下边:这是一个坑呢，一不小心代码就不好使了;
//          authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 */
//		filterChainDefinitionMap.put("/", "anon");
//		filterChainDefinitionMap.put("/static/**", "anon");
//		filterChainDefinitionMap.put("/user/auth", "anon");
//		filterChainDefinitionMap.put("/user/logout", "anon");
//		filterChainDefinitionMap.put("/error", "anon");
//
//		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
//		filterChainDefinitionMap.put("/swagger-resources", "anon");
//		filterChainDefinitionMap.put("/swagger-resources/configuration/security", "anon");
//		filterChainDefinitionMap.put("/swagger-resources/configuration/ui", "anon");
//		filterChainDefinitionMap.put("/v2/api-docs", "anon");
//		filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
//
//		filterChainDefinitionMap.put("/unauthorized/**", "anon");
////		filterChainDefinitionMap.put("/**", "anon");
//		//filterChainDefinitionMap.put("/**", "authc");
//
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		return shiroFilterFactoryBean;
//	}

	@Bean
	public ShiroFilterFactoryBean factory(SecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

		// 添加自己的过滤器并且取名为jwt
		Map<String, Filter> filterMap = new LinkedHashMap<>();
		//设置我们自定义的JWT过滤器

		filterMap.put("jwt", new JWTFilter());
		factoryBean.setFilters(filterMap);
		factoryBean.setSecurityManager(securityManager);
		// 设置无权限时跳转的 url;
		factoryBean.setUnauthorizedUrl("/unauthorized/无权限");
		Map<String, String> filterRuleMap = new HashMap<>();
		// 所有请求通过我们自己的JWT Filter
		filterRuleMap.put("/**", "jwt");
		// 访问 /unauthorized/** 不通过JWTFilter
		filterRuleMap.put("/unauthorized/**", "anon");

//		filterRuleMap.put("/static/**", "anon");
//		filterRuleMap.put("/user/auth", "anon");
//		filterRuleMap.put("/user/logout", "anon");
//		filterRuleMap.put("/error", "anon");
//
//		filterRuleMap.put("/swagger-ui.html", "anon");
//		filterRuleMap.put("/swagger-resources", "anon");
//		filterRuleMap.put("/swagger-resources/configuration/security", "anon");
//		filterRuleMap.put("/swagger-resources/configuration/ui", "anon");
//		filterRuleMap.put("/v2/api-docs", "anon");
//		filterRuleMap.put("/webjars/springfox-swagger-ui/**", "anon");


		factoryBean.setFilterChainDefinitionMap(filterRuleMap);
		return factoryBean;
	}
	/**
	 * 不指定名字的话，自动创建一个方法名第一个字母小写的bean
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm());

		/*
		 * 关闭shiro自带的session，详情见文档
		 * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
		 */
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		securityManager.setSubjectDAO(subjectDAO);

		return securityManager;
	}

	/**
	 * Shiro Realm 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类为自定义的
	 */
	@Bean
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码;
	 * ）
	 * 可以扩展凭证匹配器，实现 输入密码错误次数后锁定等功能，下一次
	 */
	@Bean(name = "credentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		//散列的次数，比如散列两次，相当于 md5(md5(""));
		hashedCredentialsMatcher.setHashIterations(2);
		//storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}

	/**
	 * Shiro生命周期处理器
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}
}