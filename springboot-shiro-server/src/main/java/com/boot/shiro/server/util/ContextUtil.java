package com.boot.shiro.server.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**spring容器获取bean工具类
 * @author fengchao
 * @date 2017年7月21日
 */
@Component
@Lazy(false)
public class ContextUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext = null;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		applicationContext = arg0;
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> requiredType,String beanName) {
		return (T) applicationContext.getBean(beanName);
	}

}
