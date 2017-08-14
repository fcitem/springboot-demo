package com.boot.shiro.server.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.shiro.server.dao.SqlMapper;
import com.boot.shiro.server.entity.User;
import com.boot.shiro.server.service.AuthorizedService;

@Service
public class AuthorizedServiceImpl implements AuthorizedService {

	@Autowired
	SqlMapper mapper;
	public Set<String> findRoles(String appKey,String loginName){
		return mapper.getRoles(loginName);
	}
	@Override
	public Set<String> findPermissions(String appKey, String loginName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> getUserInfo(String userName) {
		// TODO Auto-generated method stub
		return mapper.getUserInfo(userName);
	}
}
