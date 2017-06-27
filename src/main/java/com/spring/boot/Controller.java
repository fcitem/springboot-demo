package com.spring.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.mybatis.bean.User;
import com.boot.mybatis.bean.UserExample;
import com.boot.mybatis.bean.UserExample.Criteria;
import com.boot.mybatis.service.UserService;

/**
 * @RestController 返回json字符串的数据,spring4中引入的,不再需要@ResponseBody来配合
 * @author fengchao
 * @data 2017年6月21日
 * @ControllerAdvice来自定义为特定控制器处理异常
 */
@RestController
@RequestMapping("/test")
public class Controller {

	@Autowired UserService service;
	@RequestMapping("/")
    private String home() {
        return "Hello World!";
    }
	/**
	 * 未处理的异常全局捕捉测试
	 * @author fengchao
	 * @data 2017年6月21日
	 */
	@RequestMapping("exception")
	public int exception(){
		return 100/0;
	}
	@RequestMapping("mybatis")
	public void db(){
		UserExample example=new UserExample();
		Criteria cia=example.createCriteria();
		cia.andUsernameEqualTo("fc");
		List<User> list=service.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
}
