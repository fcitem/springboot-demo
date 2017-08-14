package com.spring.boot.druid;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * 注入jdbc数据源配置
 * @author fengchao
 * @data 2017年6月21日
 */
@Configuration
@PropertySource(value="classpath:jdbc.properties")
public class DataSourceConfig {

	@Value("${dataSource.diverClassName}")
	private String driver;
	@Value("${dataSource.url}")
	private String url;
	@Value("${dataSource.username}")
	private String username;
	@Value("${dataSource.password}")
	private String password;
	@Value("${dataSource.maxActive}")
	private int maxActive;
	@Value("${dataSource.maxIdle}")
	private int maxIdle;
	@Value("${dataSource.maxWait}")
	private long maxWait; 
	@SuppressWarnings("deprecation")
	@Bean
	public DruidDataSource dataSource() throws SQLException{
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMaxWait(maxWait);
		//设置为stat,不然无法显示SQL监控检测信息
		dataSource.setFilters("stat");
		//orcle开启Pscache功能
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(100);
		return dataSource;
	}
}
