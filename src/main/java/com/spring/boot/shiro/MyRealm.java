package com.spring.boot.shiro;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

	
	/* 用户身份验证相关信息
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=token.getPrincipal().toString();    //获取身份
		String password=token.getCredentials().toString();  //获取凭证
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				username,password,null,getName()
				);
		return authenticationInfo;
	}

	/*用户授权信息
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username=principals.getPrimaryPrincipal().toString();
		//SimpleAuthorizationInfo存储角色和权限作为框架内部使用
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		Set<String> roleNames = new LinkedHashSet<String>();
		authorizationInfo.setRoles(roleNames);
		Set<String> stringPermissions=new LinkedHashSet<String>();
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;
	}

}
