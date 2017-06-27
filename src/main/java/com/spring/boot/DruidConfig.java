package com.spring.boot;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration

public class DruidConfig {

	/**
	 * 注册druid的Servlet处理类
	 * @author fengchao
	 * @return 
	 * @data 2017年6月26日
	 */
	@Bean
	public ServletRegistrationBean DruidStatServlet(){
		ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		//添加初始化参数,ip白名单
		servletRegistrationBean.addInitParameter("allow","127.0.0.1");
		//ip黑名单
		servletRegistrationBean.addInitParameter("deny", "192.168.0.34");
		//设置用户名
		servletRegistrationBean.addInitParameter("loginUsername","admin2");
		//登录密码设置
		servletRegistrationBean.addInitParameter("loginPassword", "1234");
		//是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	@Bean
	public FilterRegistrationBean druidStatFilter(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		//添加不需要忽略的格式信息
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
