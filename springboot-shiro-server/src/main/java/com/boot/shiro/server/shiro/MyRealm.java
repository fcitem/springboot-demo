package com.boot.shiro.server.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.shiro.server.entity.User;
import com.boot.shiro.server.service.AuthorizedService;

/**自定义realm实现
 * @author fengchao
 * @date 2017年7月21日
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private AuthorizedService authorizedService;
	
	private PasswordMatcher matcher;
	
	public MyRealm(PasswordMatcher matcher) {
		this.matcher=matcher;
		this.setCredentialsMatcher(this.matcher);
	}
	/* 用户身份验证相关信息
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		userService=ContextUtil.getBean(UserService.class);
		String username=token.getPrincipal().toString();    //获取身份
		List<User> list=authorizedService.getUserInfo(username);
		User user=null;
		if(list.size()==0){
			throw new UnknownAccountException();            //未找到账号
		}else{
			user=list.get(0);
			if ("0".equals(user.getStatus()==null?"":user.getStatus().toString())) {
				throw new LockedAccountException();                  //账号被锁定
			}
		}
		String password=user.getUserPwd().toString();  //获取数据库的凭证
		//authenticationInfo里面传入的密码应该是数据库中存储的密码
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				username,password,getName());
		return authenticationInfo;
	}

	/*用户授权信息
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		roleService=ContextUtil.getBean(RoleService.class);
		/*urService=ContextUtil.getBean(UserRoleService.class);
		String loginname=principals.getPrimaryPrincipal().toString();
		List<Role> roleNames=urService.selectByLoginName(loginname);
		//SimpleAuthorizationInfo存储角色和权限作为框架内部使用
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		Set<String> roleSet=new HashSet<>();
		for (Role role : roleNames) {
			roleSet.add(role.getRoleName().toString());
			
		}
		authorizationInfo.setRoles(roleSet);
		Set<String> stringPermissions=new LinkedHashSet<String>();
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;*/
		throw new UnsupportedOperationException("暂时不会调用");
	}
}
