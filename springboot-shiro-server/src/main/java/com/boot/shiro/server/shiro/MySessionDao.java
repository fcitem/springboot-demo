package com.boot.shiro.server.shiro;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

/**根据需求扩展sessionDao
 * @author fengchao
 *
 */
public class MySessionDao extends EnterpriseCacheSessionDAO{
	

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		super.create(session);
	}

	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		super.doUpdate(session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		return super.doCreate(session);
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return super.doReadSession(sessionId);
	}

}
