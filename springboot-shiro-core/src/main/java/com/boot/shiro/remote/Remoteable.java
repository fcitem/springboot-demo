package com.boot.shiro.remote;

import java.io.Serializable;

import org.apache.shiro.session.Session;

import com.boot.shiro.core.PermissionContext;

/**远程服务暴露接口
 * @author fengchao
 *
 */
public interface Remoteable {

	Session getSession(String appKey, Serializable sessionId);

	Serializable createSession(Session session);

	void updateSession(String appKey, Session session);

	public void deleteSession(String appKey, Session session);

	public PermissionContext getPermissions(String appKey, String username);
}
