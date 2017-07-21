package com.boot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mybatis.bean.Role;
import com.boot.mybatis.bean.RoleExample;
import com.boot.mybatis.dao.RoleMapper;
import com.boot.mybatis.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleMapper mapper;
	@Override
	public int countByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String roleId) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public List<Role> selectByExample(RoleExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}

	@Override
	public Role selectByPrimaryKey(String roleId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByExampleSelective(Role record, RoleExample example) {
		// TODO Auto-generated method stub
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Role record, RoleExample example) {
		// TODO Auto-generated method stub
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
