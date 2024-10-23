package com.human.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.human.dto.UserDto;

public interface IUserDao {
	public void insert(UserDto dto) throws Exception;
	public UserDto select(String userId) throws Exception;
	
	public List<UserDto> selectAll() throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void update(UserDto dto) throws Exception;
	
	public boolean login(@Param("id")String id, @Param("pw")String pw);
}



