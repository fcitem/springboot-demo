package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * 启动springBoot容器
 * @RestController 返回json字符串的数据
 * @author fengchao
 * @data 2017年6月21日
 * @ControllerAdvice来自定义为特定控制器处理异常
 */
//@SpringBootApplication
@ComponentScan(basePackages={"com.spring.boot","com.boot.mybatis.service","com.boot.shiro.client","com.boot.mybatis.config"})
@EnableAutoConfiguration
@EnableConfigurationProperties
public class BootStart {

	@Autowired
	Environment env;
	/**
	 * 注入bean的方式修改内置tomcat的发布端口
	 * @author fengchao
	 * @return 
	 * @data 2017年6月21日
	 */
	/*@Bean
	public TomcatEmbeddedServletContainerFactory container(){
		TomcatEmbeddedServletContainerFactory factory=new TomcatEmbeddedServletContainerFactory();
		factory.setPort(8081);
		factory.setSessionTimeout(10000,TimeUnit.SECONDS);
		return factory;
	}*/
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootStart.class, args);
    }
}
