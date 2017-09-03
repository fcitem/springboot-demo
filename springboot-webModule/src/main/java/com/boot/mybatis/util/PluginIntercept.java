package com.boot.mybatis.util;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts(@Signature(args= {Connection.class,Integer.class},method= "prepare",type= StatementHandler.class))
public class PluginIntercept implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Connection conn=(Connection) invocation.getArgs()[0];
		StatementHandler handler=(StatementHandler) invocation.getTarget();
		BoundSql boundSql=handler.getBoundSql();
		Object obj=boundSql.getParameterObject();
		String sql=boundSql.getSql();
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// 生成代理对象
		if(target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		}
		else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
