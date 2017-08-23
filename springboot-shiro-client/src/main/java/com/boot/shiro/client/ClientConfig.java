package com.boot.shiro.client;

import org.springframework.beans.factory.annotation.Value;
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

	public String getAppKey() {
		return appKey;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public String getCookieDomain() {
		return cookieDomain;
	}

	public String getCookiePath() {
		return cookiePath;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getRememberMeId() {
		return rememberMeId;
	}

	public String getFilters() {
		return filters;
	}

	public String getDefinitions() {
		return definitions;
	}
	/*@Bean
	public ClientConfig getClientCofig() {
		return this;
	}*/
}
