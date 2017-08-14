package com.boot.shiro.server.remote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.boot.shiro.remote.Remoteable;

/**
 * 导出远程http服务
 * @author fengchao
 *
 */
@Configuration
public class RemoteConfig {

	@Bean
	private RemoteService getReoteService() {
		return new RemoteService();
	}
	@Bean(name="/remoteService")
    private HttpInvokerServiceExporter getHttpInvokerServiceExporter() {
		HttpInvokerServiceExporter exporter=new HttpInvokerServiceExporter();
		exporter.setService(getReoteService());
		exporter.setServiceInterface(Remoteable.class);
		return exporter;
	}
}
