package com.boot.shiro.server.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value="login/{username}/{password}",method=RequestMethod.GET)
	public void test(@PathVariable(name="username") String username,@PathVariable(name="password") String password){
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		Subject sub=SecurityUtils.getSubject();
		try{
			sub.login(token);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value="login/{username}/{password}",method=RequestMethod.POST)
	public void testpost(@PathVariable(name="username") String username,@PathVariable(name="password") String password){
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		Subject sub=SecurityUtils.getSubject();
		try{
			sub.login(token);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
