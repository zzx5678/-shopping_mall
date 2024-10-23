package com.human.service;

import java.util.List;



import com.human.dto.UserDto;

public interface IUserService {
	public void insert(UserDto dto) throws Exception;
	public UserDto select(String userId) throws Exception;
	
	public List<UserDto> selectAll() throws Exception;
	public void delete(String id) throws Exception;
	public void update(UserDto dto) throws Exception;	
	
	public boolean login(String id, String pw);
	
}
