package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:shiro-client-default.properties",
		"classpath:shiro-client.properties" }, ignoreResourceNotFound = true)
public class ClientConfig {
	
	@Autowired
    private Environment env;

	@Bean
	public ClientProperties getClientProperties() {
		ClientProperties config=new ClientProperties();
		config.setAppKey(env.getProperty("client.app.key"));
		config.setCookieDomain(env.getProperty("client.cookie.domain"));
		config.setCookiePath(env.getProperty("client.cookie.path"));
		config.setDefinitions(env.getProperty("client.filter.chain.definitions"));
		config.setFilters(env.getProperty("client.filters"));
		config.setLoginUrl(env.getProperty("client.login.url"));
		config.setRememberMeId(env.getProperty("client.rememberMe.id"));
		config.setServiceUrl(env.getProperty("client.remote.service.url"));
		config.setSessionId(env.getProperty("client.session.id"));
		config.setSuccessUrl(env.getProperty("client.success.url"));
		config.setUnauthorizedUrl(env.getProperty("client.unauthorized.url"));
		return config;
	}
}
