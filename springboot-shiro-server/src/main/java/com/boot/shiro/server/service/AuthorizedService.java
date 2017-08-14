package com.boot.shiro.server.service;

import java.util.List;
import java.util.Set;

import com.boot.shiro.server.entity.User;

public interface AuthorizedService {
	
	Set<String> findRoles(String appKey,String loginName);
	
	Set<String> findPermissions(String appKey,String loginName);
	
	List<User> getUserInfo(String userName);

}
