package com.boot.shiro.server.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.boot.shiro.server.entity.User;

/**注解方式动态sql封装引用
 * @author fengchao
 * @data 2017年5月27日
 */
public interface SqlMapper {

	/**自定义sql，根据登录id获取相应的角色
	 * @author fengchao
	 * @data 2017年5月27日
	 */
	@SelectProvider(type=com.boot.shiro.server.util.SqlUtil.class, method="selectRolesByLoginId")  
	Set<String> getRoles(String loginId);
	
	/**
	 * 认证用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	@Select("select * from sys_user where login_id=#{username}")
	List<User> getUserInfo(String username);
}
