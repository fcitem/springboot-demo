package com.boot.shiro.client;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.shiro.core.PermissionContext;
import com.boot.shiro.remote.Remoteable;

/**
 * 重写realm的认证授权实现，远程调用服务获取权限
 * @author fengchao
 *
 */
public class ClientRealm extends AuthorizingRealm{

	@Autowired
	private Remoteable remoteService;
	public ClientRealm() {
		// TODO Auto-generated constructor stub
		System.out.println("ss");
	}
	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Remoteable getRemoteService() {
		return remoteService;
	}

	public void setRemoteService(Remoteable remoteService) {
		this.remoteService = remoteService;
	}

	private String appKey;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        PermissionContext permission=remoteService.getPermissions(appKey, username);
        info.setRoles(permission.getRoles());
        info.setStringPermissions(permission.getPermissions());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("远程服务认证,这儿不应该被调用");
	}

}
