 package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.IOrderDao;
import com.human.dto.OrderDto;


@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert_session(OrderDto dto) throws Exception {
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		dao.insert_session(dto);		
	}
	@Override
	public void insert_user(OrderDto dto) throws Exception {
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		dao.insert_user(dto);		
	}
	
	@Override
	public OrderDto select_session(String order_id, String session_id) throws Exception {
		System.out.println("Calling select_session with order_id=" + order_id + " and session_id=" + session_id);
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		return dao.select_session(order_id, session_id);
	}
	@Override
	public OrderDto select_session_pw(String order_id, String order_phoneNumber, String order_password) throws Exception {
		System.out.println("Calling select_session with order_id=" + order_id + " and order_phoneNumber=" + order_phoneNumber + " and order_password=" + order_password);
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		return dao.select_session_pw(order_id, order_phoneNumber, order_password);
	}
	@Override
	public OrderDto select_user(String order_id, String user_id) throws Exception {
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		return dao.select_user(order_id, user_id);
	}
	
	@Override
	public List<OrderDto> selectAll() throws Exception {
		IOrderDao dao=sqlSession.getMapper(IOrderDao.class);
		return dao.selectAll();
		
	}
}
