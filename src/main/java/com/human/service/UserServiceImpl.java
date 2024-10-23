package com.human.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.IUserDao;
import com.human.dto.UserDto;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(UserDto dto) throws Exception {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		dao.insert(dto);		
	}

	@Override
	public UserDto select(String userId) throws Exception {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		
		return dao.select(userId);
	}

	@Override
	public List<UserDto> selectAll() throws Exception {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		System.out.println("dao from selectAll: " + dao);
		return dao.selectAll();
	}

	@Override
	public void delete(String id) throws Exception {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		dao.delete(id);
	}

	@Override
	public void update(UserDto dto) throws Exception {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		dao.update(dto);
		
	}


	@Override
	public boolean login(String id, String pw) {
		IUserDao dao=sqlSession.getMapper(IUserDao.class);
		
		return dao.login(id,pw);
	}

}
