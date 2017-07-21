package com.spring.boot.shiro;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring.boot.druid.DataSourceConfig;

/**
 * shiro集成配置
 * @author fengchao
 * @data 2017年6月28日
 */
@Configuration
@Import({DataSourceConfig.class})
public class ShiroFilterFactory {
	/**
	 * shiro过滤器入口
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilter(DruidDataSource dataSource){
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		SecurityManager manager=getSecurityManager(dataSource);
		bean.setSecurityManager(manager);
//		bean.setLoginUrl(loginUrl);    web请求登录拦截
		return bean;
	}
	/**
	 * shiro 安全管理器
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public SecurityManager getSecurityManager(DruidDataSource dataSource){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//		securityManager.setRealm(getJdbcRealm(dataSource));      //设置安全数据源域
		MyRealm realm=new MyRealm(getPasswordMatcher());
		securityManager.setRealm(realm);
		securityManager.setSessionManager(getSessionManager());    //设置安全管理器
		return securityManager;
	}
	@Bean
	/**
	 * shiro的real安全数据源
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	/*@Bean*/
	public JdbcRealm getJdbcRealm(DruidDataSource dataSource){
		JdbcRealm realm=new JdbcRealm();
		realm.setDataSource(dataSource);
		//验证查询sql
		realm.setAuthenticationQuery("select user_passwd from user where user_name=?");
		realm.setCredentialsMatcher(getPasswordMatcher());     //设置匹配器
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
	 * session管理器,这儿使用其他的session非shiro自带的session
	 * @author fengchao
	 * @data 2017年6月28日
	 */
	@Bean
	public SessionManager getSessionManager(){
		DefaultSessionManager sessionManager=new DefaultSessionManager();
		ExecutorServiceSessionValidationScheduler validationScheduler=new ExecutorServiceSessionValidationScheduler();
		validationScheduler.setInterval(2000);
		sessionManager.setSessionValidationScheduler(validationScheduler);
		sessionManager.setSessionDAO(new MemorySessionDAO());
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setDeleteInvalidSessions(true);    //删除失效session
		//开启session定时检查任务
		sessionManager.setSessionValidationSchedulerEnabled(true);
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
}
