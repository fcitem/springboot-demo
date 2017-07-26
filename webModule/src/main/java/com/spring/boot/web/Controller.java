package com.spring.boot.web;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	@Autowired PasswordMatcher passwordMatcher;
	
	private static Logger logger=LoggerFactory.getLogger(Controller.class);
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
		cia.andUserNameEqualTo("fc");
		List<User> list=service.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUserName());
		}
	}
	@RequestMapping("register")
	public void register(){
		User user=new User();
		String userName="fc3";
		String password="1234";
		String userId=UUID.randomUUID().toString().replaceAll("-","").substring(0, 32);
		user.setUserId(userId);
		user.setLoginId("fc");
		user.setUserName(userName);
		user.setUserPwd(passwordMatcher.getPasswordService().encryptPassword(password));
		service.insertSelective(user);
	}
	@RequestMapping("login")
	public void login(){
		logger.info("测试");
		Subject sub=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("fc","1234");
		try{
			sub.login(token);
			sub.hasRole("dede");
			System.out.println(token.getPrincipal()+":验证通过");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(token.getPrincipal()+":验证失败");
		}
	}
}
