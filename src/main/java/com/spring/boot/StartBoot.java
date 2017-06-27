package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动springBoot容器
 * @RestController 返回json字符串的数据
 * @author fengchao
 * @data 2017年6月21日
 * @ControllerAdvice来自定义为特定控制器处理异常
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.spring.boot","com.boot.mybatis.service"})
public class StartBoot {

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
        SpringApplication.run(StartBoot.class, args);
    }
}
