package com.boot.mybatis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.boot.mybatis.bean.Role;
import com.boot.mybatis.bean.UserRole;
import com.boot.mybatis.bean.UserRoleExample;

public interface UserRoleService {

	int countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    List<Role> selectByLoginName(@Param("record") String loginId);
}
