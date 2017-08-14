package com.spring.boot.web;

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
@Order(value=2)
public class StartAfterRunner2 implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("**********SpringBoot启动完成,执行加载初始数据2*******************");
	}
}
