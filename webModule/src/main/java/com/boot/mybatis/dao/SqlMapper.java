package com.boot.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.boot.mybatis.bean.Role;

/**注解方式动态sql封装引用
 * @author fengchao
 * @data 2017年5月27日
 */
public interface SqlMapper {

	/**自定义sql，根据登录id获取相应的角色
	 * @author fengchao
	 * @data 2017年5月27日
	 */
	@SelectProvider(type=com.boot.mybatis.util.SqlUtil.class, method="selectRolesByLoginId")  
	List<Role> selectByLoginName(String loginId);
}
