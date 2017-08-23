package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

@Configuration
@Import(ClientConfig.class)
public class RemoteConfig {
	@Autowired
	ClientConfig conf;
	public RemoteConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("sdsd");
	}
	@Bean(name="ClientConfig")
    public HttpInvokerProxyFactoryBean getHttpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean invokeProxy=new HttpInvokerProxyFactoryBean();
		invokeProxy.setServiceUrl(conf.getServiceUrl());
		invokeProxy.setServiceInterface(Remoteable.class);
		return invokeProxy;
	}
}
