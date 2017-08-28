package com.boot.shiro.client;

import java.util.HashMap;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * shiro集成配置 注意@Configuration配置的类不能通过属性的方式注入@bean标记的bean，因为那个时候bean还不存在
 * @author fengchao
 * @data 2017年6月28日
 * 注意:@Autowired只有在bean注入完成的情况下才能够注入,比如在filter注入之前无法注入bean
 */
@Configuration
@PropertySource(value = { "classpath:shiro-client-default.properties",
		"classpath:shiro-client.properties" }, ignoreResourceNotFound = true)
@Import(RemoteConfig.class)
public class ShiroFilterFactory {
	
	@Autowired
	Environment env;
	
	/**
	 * shiro过滤器入口
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilter(ClientProperties conf,HttpInvokerProxyFactoryBean invoke){
		ClientShiroFilterFactoryBean bean=new ClientShiroFilterFactoryBean();
		SecurityManager manager=getSecurityManager(conf);
		bean.setSecurityManager(manager);
		bean.setLoginUrl(conf.getLoginUrl());    //web请求登录拦截
		bean.setSuccessUrl(conf.getSuccessUrl());
		bean.setUnauthorizedUrl(conf.getUnauthorizedUrl());
		HashMap<String, Filter> filtermap=new HashMap<>();
		filtermap.put("authc", new ClientAuthenticationFilter());
		bean.setFilters(filtermap);
		bean.setFiltersStr(conf.getFilters());
		bean.setFilterChainDefinitionsStr(conf.getDefinitions());
		return bean;
	}
	/**
	 * shiro 安全管理器
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public SecurityManager getSecurityManager(ClientProperties conf){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		ClientRealm realm=getClientRealm();
		realm.setAppKey(conf.getAppKey());
		//TODO
//		realm.setInvokerProxy(invoke);
		realm.setCachingEnabled(false);
		securityManager.setRealm(realm);
		securityManager.setSessionManager(getSessionManager(conf));    //设置安全管理器
		return securityManager;
	}
	@Bean
	public ClientRealm getClientRealm(){
		ClientRealm realm=new ClientRealm();
		return realm;
	}
	/**
	 * 密码匹配器
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public PasswordMatcher getPasswordMatcher(){
		PasswordMatcher matcher=new PasswordMatcher();
		DefaultPasswordService passwdService=new DefaultPasswordService();
		DefaultHashService hashService=new DefaultHashService();   //散列
		hashService.setHashAlgorithmName("md5");                //md5的方式散列
		hashService.setGeneratePublicSalt(true);                //产生公有salt
		hashService.setHashIterations(2);                     //迭代2次
		passwdService.setHashService(hashService);
	    matcher.setPasswordService(passwdService);
	    return matcher;
	}
	/**
	 * session管理器,使用shiro自带的session
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public SessionManager getSessionManager(ClientProperties conf){
		DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		ExecutorServiceSessionValidationScheduler validationScheduler=new ExecutorServiceSessionValidationScheduler();
		validationScheduler.setSessionManager(sessionManager);
		sessionManager.setSessionValidationScheduler(validationScheduler);
		sessionManager.setSessionValidationSchedulerEnabled(false);
		sessionManager.setSessionDAO(getSessionDao(conf));
		sessionManager.setDeleteInvalidSessions(false);    //删除失效session
		sessionManager.setSessionIdCookie(getSessionIdCookie(conf));
		sessionManager.setSessionIdCookieEnabled(true);
		return sessionManager;
	}
	/**
	 * 用于在实现了Initializable接口和Destroyable接口的bean初始化或者销毁时调用相关的接口回调
	 * @author fengchao
	 * @data 2017年6月29日
	 */
	@Bean
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	/**
	 * sessionid的cookie模板
	 * @return cookie
	 */
	@Bean
	public Cookie getSessionIdCookie(ClientProperties conf) {
		SimpleCookie cookie=new SimpleCookie(conf.getSessionId());
		cookie.setHttpOnly(true);
		cookie.setMaxAge(-1);      //设置会话级cookie,浏览器关闭失效
		cookie.setDomain(conf.getCookieDomain());
		cookie.setPath(conf.getCookiePath());
		return cookie;
	}
	@Bean                                  
	public ClientSessionDAO getSessionDao(ClientProperties conf) {
		ClientSessionDAO sessionDAO=new ClientSessionDAO();
		sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
		sessionDAO.setAppKey(conf.getAppKey());
		//TODO: 这儿需要注入远程服务
//		sessionDAO.setInvokerProxy(invoke);
		return sessionDAO;
	}
}
