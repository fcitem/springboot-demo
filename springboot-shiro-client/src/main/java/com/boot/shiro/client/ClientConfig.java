package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:shiro-client-default.properties",
		"classpath:shiro-client.properties" }, ignoreResourceNotFound = true)
public class ClientConfig {
	
	@Value("${client.app.key}")
	private String appKey;

	@Value("${client.remote.service.url}")
	private String serviceUrl;

	@Value("${client.login.url}")
	private String loginUrl;

	@Value("${client.success.url}")
	private String successUrl;

	@Value("${client.unauthorized.url}")
	private String unauthorizedUrl;

	@Value("${client.cookie.domain}")
	private String cookieDomain;

	@Value("${client.cookie.path}")
	private String cookiePath;
	
	@Value("${client.session.id}")
	private String sessionId;
	
	@Value("${client.rememberMe.id}")
	private String rememberMeId;
	
	@Value("${client.filters}")
	private String filters;
	
	@Value("${client.filter.chain.definitions}")
	private String definitions;

	@Bean
	public ClientProperties getClientProperties() {
		ClientProperties config=new ClientProperties();
		config.setAppKey(appKey);
		config.setCookieDomain(cookieDomain);
		config.setCookiePath(cookiePath);
		config.setDefinitions(definitions);
		config.setFilters(filters);
		config.setLoginUrl(loginUrl);
		config.setRememberMeId(rememberMeId);
		config.setServiceUrl(serviceUrl);
		config.setSessionId(sessionId);
		config.setSuccessUrl(successUrl);
		config.setUnauthorizedUrl(unauthorizedUrl);
		return config;
	}
}
