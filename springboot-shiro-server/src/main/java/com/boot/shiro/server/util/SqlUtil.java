package com.boot.shiro.server.util;

public class SqlUtil {

	public String selectRolesByLoginId(String loginId){
		StringBuilder builder=new StringBuilder();
		builder.append("select r.role_name from SYS_USER_ROLE ur inner join SYS_USER u on ur.user_id=u.user_id inner join sys_role r on ur.role_id=r.role_id");
		builder.append(" where u.login_id='").append(loginId).append("'");
		return builder.toString();
	}
}
