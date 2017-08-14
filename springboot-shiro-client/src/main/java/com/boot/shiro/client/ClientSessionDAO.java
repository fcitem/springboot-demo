package com.boot.shiro.client;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import com.boot.shiro.remote.Remoteable;

/**自定义session相关操作,依赖于远程服务获取
 * @author fengchao
 *
 */
public class ClientSessionDAO extends CachingSessionDAO{
	
	private Remoteable remoteService;
	private String appKey;

	public Remoteable getRemoteService() {
		return remoteService;
	}

	public void setRemoteService(Remoteable remoteService) {
		this.remoteService = remoteService;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Override
	protected void doDelete(Session session) {
		remoteService.deleteSession(appKey, session);
	}

	@Override
	protected void doUpdate(Session session) {
		remoteService.updateSession(appKey, session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		return remoteService.createSession(session);
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return remoteService.getSession(appKey, sessionId);
	}

}
