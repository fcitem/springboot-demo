package com.boot.mybatis.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.util.ReflectionUtils;

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
		List<ParameterMapping> list=boundSql.getParameterMappings();
//		Configuration configuration= (Configuration) reflectField("configuration",list.get(0));      //反射获取configuration
//		BoundSql pageBound=new BoundSql(configuration,generatePageSql(sql),boundSql.getParameterMappings(),obj);   //重新组建修改过的包含分页语句的sql
		setField("sql", boundSql,generatePageSql(sql));                //修改Bound中的sql值
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
	public String generatePageSql(String sql){
		StringBuilder pageSql=new StringBuilder();
		pageSql.append("select tmp.*,rownum from(").append(sql).append(")tmp where rownum<=10");
		return pageSql.toString();
	}
	public <T> Object reflectField(String fieldName,T obj){
		Field field=ReflectionUtils.findField(obj.getClass(),fieldName);
		field.setAccessible(true);
		return ReflectionUtils.getField(field, obj);
	}
	public <T> void setField(String fieldName,BoundSql boundSql,String string){
		Field field=ReflectionUtils.findField(boundSql.getClass(),fieldName);
		field.setAccessible(true);
		try {
			field.set(boundSql,string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
