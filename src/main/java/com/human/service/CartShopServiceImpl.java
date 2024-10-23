package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.ICartDao;

import com.human.dao.IShopDao;
import com.human.dto.CartDto;
import com.human.dto.CartShopDto;
import com.human.dto.ShopDto;
@Service
public class CartShopServiceImpl implements ICartShopService {

	@Autowired
	private SqlSession sqlSession;
	

	@Autowired
	private ICartService cartService;
	@Autowired
	private IShopService shopService;
	
	@Autowired
	private ICartShopService cartshopService;
	
	@Override
	public List<CartShopDto> selectAll_CartShop_session(String sessionId) throws Exception {
		ICartDao dao= sqlSession.getMapper(ICartDao.class);
		List<CartShopDto> dtos= dao.selectAll_CartShop_session(sessionId);
		return dtos;
	}
	
	@Override
	public List<CartShopDto> selectAll_CartShop_user(String userId) throws Exception {
		ICartDao dao= sqlSession.getMapper(ICartDao.class);
		List<CartShopDto> dtos= dao.selectAll_CartShop_user(userId);
		return dtos;
	}
	
	@Override
	public void delete_session(String session_id, String product_code) throws Exception  {
		cartService.delete_S(session_id, product_code);
	}
	
	@Override
	public void delete_user(String user_id, String product_code) throws Exception{
		cartService.delete_U(user_id, product_code);
	}
	
	@Override
	public List<CartShopDto> selectAll_CartShop() throws Exception {
		ICartDao dao= sqlSession.getMapper(ICartDao.class);
		List<CartShopDto> dtos= dao.selectAll_CartShop();
		return dtos;
	}
}
