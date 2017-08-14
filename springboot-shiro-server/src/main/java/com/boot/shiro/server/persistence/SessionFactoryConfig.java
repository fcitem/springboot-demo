package com.boot.shiro.server.persistence;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Mybatis中的SessionFactory配置
 * @author fengchao
 * @data 2017年6月24日
 */
@Configuration
@MapperScan(basePackages={"com.boot.shiro.server.dao"})
@EnableTransactionManagement
public class SessionFactoryConfig implements TransactionManagementConfigurer{

	@Autowired
	private DruidDataSource dataSource;
	private final String typeAliasPackage ="com.boot.shiro.server.entity";
	
	/**
	 * SqlSessionFactoryBean创建
	 * @author fengchao
	 * @throws IOException 
	 * @data 2017年6月22日
	 */
	@Bean
	public SqlSessionFactoryBean createSqlSessionBean() throws IOException{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		/**设置数据源**/
		bean.setDataSource(dataSource);
		/**设置typeAlias 包扫描路径**/
		bean.setTypeAliasesPackage(typeAliasPackage);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		return bean;
	}
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
