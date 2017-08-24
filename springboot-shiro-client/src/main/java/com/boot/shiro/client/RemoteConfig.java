package com.boot.shiro.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

@Configuration
@Import(ClientConfig.class)
public class RemoteConfig {
	
	@Bean
    public HttpInvokerProxyFactoryBean getHttpInvokerProxyFactoryBean(ClientProperties conf) {
		HttpInvokerProxyFactoryBean invokeProxy=new HttpInvokerProxyFactoryBean();
		invokeProxy.setServiceUrl(conf.getServiceUrl());
		invokeProxy.setServiceInterface(Remoteable.class);
		return invokeProxy;
	}
}
