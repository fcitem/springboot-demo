package com.spring.boot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @author fengchao
 * @data 2017年6月26日
 */
@Configuration
@EnableScheduling
public class ScheduConfig {

	private static int count=0;
	@Scheduled(cron="0/20 * * * * ?")  //每20秒执行一次
	public void scheduler(){
		count++;
		System.out.println("第"+count+"次执行定时任务");
	}
}
