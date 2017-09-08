package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

@Configuration
public class RemoteConfig {
	
	@Autowired
	private ClientProperties config;
	
	@Bean
    public HttpInvokerProxyFactoryBean getHttpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean invokeProxy=new HttpInvokerProxyFactoryBean();
		invokeProxy.setServiceUrl(config.getServiceUrl());
		invokeProxy.setServiceInterface(Remoteable.class);
		return invokeProxy;
	}
	
//	@Bean
//	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(){
//		AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
//		advisor.setSecurityManager(securityManager);
//		return advisor;
//	}
}
