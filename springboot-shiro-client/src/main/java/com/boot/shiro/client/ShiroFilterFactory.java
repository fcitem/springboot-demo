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
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

/**
 * shiro集成配置
 * @author fengchao
 * @data 2017年6月28日
 */
@Configuration
public class ShiroFilterFactory {
	@Autowired
	Environment env;
	/**
	 * shiro过滤器入口
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilter(HttpInvokerProxyFactoryBean invokeproxy){
		ClientShiroFilterFactoryBean bean=new ClientShiroFilterFactoryBean();
		SecurityManager manager=getSecurityManager(invokeproxy);
		bean.setSecurityManager(manager);
		bean.setLoginUrl(env.getProperty("client.login.url"));    //web请求登录拦截
		bean.setSuccessUrl(env.getProperty("client.success.url"));
		bean.setUnauthorizedUrl(env.getProperty("client.unauthorized.url"));
		HashMap<String, Filter> filtermap=new HashMap<>();
		filtermap.put("authc", new ClientAuthenticationFilter());
		bean.setFilters(filtermap);
		bean.setFiltersStr(env.getProperty("client.filters"));
		bean.setFilterChainDefinitionsStr(env.getProperty("client.filter.chain.definitions"));
		return bean;
	}
	/**
	 * shiro 安全管理器
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public SecurityManager getSecurityManager(HttpInvokerProxyFactoryBean invokeproxy){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		ClientRealm realm=new ClientRealm();
		realm.setAppKey(env.getProperty("client.app.key"));
		realm.setRemoteService((Remoteable) invokeproxy);
		realm.setCachingEnabled(false);
		securityManager.setRealm(realm);
		securityManager.setSessionManager(getSessionManager(invokeproxy));    //设置安全管理器
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
	public SessionManager getSessionManager(HttpInvokerProxyFactoryBean invokeproxy){
		DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
		ExecutorServiceSessionValidationScheduler validationScheduler=new ExecutorServiceSessionValidationScheduler();
		validationScheduler.setSessionManager(sessionManager);
		sessionManager.setSessionValidationScheduler(validationScheduler);
		sessionManager.setSessionValidationSchedulerEnabled(false);
		sessionManager.setSessionDAO(getSessionDao(invokeproxy));
		sessionManager.setDeleteInvalidSessions(false);    //删除失效session
		sessionManager.setSessionIdCookie(getSessionIdCookie());
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
	private Cookie getSessionIdCookie() {
		SimpleCookie cookie=new SimpleCookie(env.getProperty("client.session.id"));
		cookie.setHttpOnly(true);
		cookie.setMaxAge(-1);      //设置会话级cookie,浏览器关闭失效
		cookie.setDomain(env.getProperty("client.cookie.domain"));
		cookie.setPath(env.getProperty("client.cookie.path"));
		return cookie;
	}
	@Bean
	private ClientSessionDAO getSessionDao(HttpInvokerProxyFactoryBean invokeproxy) {
		ClientSessionDAO sessionDAO=new ClientSessionDAO();
		sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
		sessionDAO.setAppKey(env.getProperty("client.app.key"));
		//TODO: 这儿需要注入远程服务
		sessionDAO.setRemoteService((Remoteable) invokeproxy);
		return sessionDAO;
	}
}
