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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

/**
 * shiro集成配置 注意@Configuration配置的类不能通过属性的方式注入@bean标记的bean，因为那个时候bean还不存在
 * @author fengchao
 * @data 2017年6月28日
 */
@Configuration
@Import(value={RemoteConfig.class,ClientConfig.class})
public class ShiroFilterFactory {
	
	/**
	 * shiro过滤器入口
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilter(HttpInvokerProxyFactoryBean invokeproxy,ClientProperties conf){
		ClientShiroFilterFactoryBean bean=new ClientShiroFilterFactoryBean();
		SecurityManager manager=getSecurityManager(invokeproxy,conf);
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
	public SecurityManager getSecurityManager(HttpInvokerProxyFactoryBean invokeproxy,ClientProperties conf){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		ClientRealm realm=new ClientRealm();
		realm.setAppKey(conf.getAppKey());
//		realm.setRemoteService((Remoteable) (invokeproxy.getObject()));
		realm.setCachingEnabled(false);
		securityManager.setRealm(realm);
		securityManager.setSessionManager(getSessionManager(invokeproxy,conf));    //设置安全管理器
		return securityManager;
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
	public SessionManager getSessionManager(HttpInvokerProxyFactoryBean invokeproxy,ClientProperties conf){
		DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		ExecutorServiceSessionValidationScheduler validationScheduler=new ExecutorServiceSessionValidationScheduler();
		validationScheduler.setSessionManager(sessionManager);
		sessionManager.setSessionValidationScheduler(validationScheduler);
		sessionManager.setSessionValidationSchedulerEnabled(false);
		sessionManager.setSessionDAO(getSessionDao(invokeproxy,conf));
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
	public ClientSessionDAO getSessionDao(HttpInvokerProxyFactoryBean invokeproxy,ClientProperties conf) {
		ClientSessionDAO sessionDAO=new ClientSessionDAO();
		sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
		sessionDAO.setAppKey(conf.getAppKey());
		//TODO: 这儿需要注入远程服务
//		sessionDAO.setRemoteService((Remoteable) invokeproxy);
		return sessionDAO;
	}
}
