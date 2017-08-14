package com.boot.shiro.server.remote;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.shiro.core.PermissionContext;
import com.boot.shiro.remote.Remoteable;
import com.boot.shiro.server.service.AuthorizedService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-3-13
 * <p>Version: 1.0
 */
public class RemoteService implements Remoteable {

    @Autowired
    private AuthorizedService authorizedService;

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public Session getSession(String appKey, Serializable sessionId) {
        return sessionDAO.readSession(sessionId);
    }

    @Override
    public Serializable createSession(Session session) {
        return sessionDAO.create(session);
    }

    @Override
    public void updateSession(String appKey, Session session) {
        sessionDAO.update(session);
    }

    @Override
    public void deleteSession(String appKey, Session session) {
        sessionDAO.delete(session);
    }

    @Override
    public PermissionContext getPermissions(String appKey, String username) {
        PermissionContext permissionContext = new PermissionContext();
        permissionContext.setRoles(authorizedService.findRoles(appKey, username));
        permissionContext.setPermissions(authorizedService.findPermissions(appKey, username));
        return permissionContext;
    }
}
