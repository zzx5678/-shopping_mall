 package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.IShopDao;
import com.human.dto.ShopDto;

@Service
public class ShopServiceImpl implements IShopService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(ShopDto dto) throws Exception {
		IShopDao dao=sqlSession.getMapper(IShopDao.class);
		dao.insert(dto);		
	}
	@Override
	public ShopDto select(String code) throws Exception {
		IShopDao dao=sqlSession.getMapper(IShopDao.class);
		return dao.select(code);
	}

	@Override
	public List<ShopDto> selectAll() throws Exception {
		IShopDao dao=sqlSession.getMapper(IShopDao.class);
		System.out.println("dao from selectAll: " + dao);
		return dao.selectAll();
		
	}

	@Override
	public void delete(String code) throws Exception {
		IShopDao dao=sqlSession.getMapper(IShopDao.class);
		dao.delete(code);
		
	}

	@Override
	public void update(ShopDto dto) throws Exception {
		IShopDao dao=sqlSession.getMapper(IShopDao.class);
		dao.update(dto);
		
	}

}
