package com.boot.shiro.server.remote;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.boot.shiro.remote.Remoteable;

/**
 * 导出远程http服务
 * @author fengchao
 *
 */
@Configurable
@Configuration
@EnableAutoConfiguration
public class RemoteConfig {

	@Bean
	public RemoteService getRemoteService() {
		return new RemoteService();
	}
	@Bean
    public HttpInvokerServiceExporter getHttpInvokerServiceExporter() {
		HttpInvokerServiceExporter exporter=new HttpInvokerServiceExporter();
		exporter.setService(getRemoteService());
		exporter.setServiceInterface(Remoteable.class);
		return exporter;
	}
}
