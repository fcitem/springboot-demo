package com.spring.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在springBoot容器启动完成之后立即执行
 * @Order 指定启动之后执行的顺序
 * @author fengchao
 * @data 2017年6月27日
 */
@Component
@Order(value=1)    
public class StartAfterRunner implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("**********SpringBoot启动完成,执行加载初始数据1*******************");
	}

}
