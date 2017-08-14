package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.boot.shiro.remote.Remoteable;

@Configuration
@PropertySource(value= {"classpath:shiro-client-default.properties","classpath:shiro-client.properties"},ignoreResourceNotFound=true)
public class RemoteConfig {
	@Autowired
	Environment env;
	@Bean
    private HttpInvokerProxyFactoryBean getHttpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean invokeProxy=new HttpInvokerProxyFactoryBean();
		invokeProxy.setServiceUrl(env.getProperty("client.remote.service.url"));
		invokeProxy.setServiceInterface(Remoteable.class);
		return invokeProxy;
	}
}
