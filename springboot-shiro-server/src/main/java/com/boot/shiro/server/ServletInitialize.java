package com.boot.shiro.server;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**注册启动类,主要用于打war包到tomcat容器中,否则无法集成部署
 * @author fengchao
 *
 */
public class ServletInitialize extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StartBoot.class);
	}
}
