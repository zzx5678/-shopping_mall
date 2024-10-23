 package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.ICartDao;
import com.human.dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert_session(CartDto dto) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.insert_session(dto);		
	}
	@Override
	public void insert_user(CartDto dto) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.insert_user(dto);		
	}
	
	@Override
	public List<CartDto> selectAll_session() throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		System.out.println("dao from selectAll_session : " + dao);
		return dao.selectAll_session();
	}
	@Override
	public List<CartDto> selectAll_user() throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		System.out.println("dao from selectAll_user : " + dao);
		return dao.selectAll_user();
	}
	
	@Override
	public void all_delete_session_id(String session_id) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.all_delete_session_id(session_id);
	}
	@Override
	public void all_delete_user_id(String user_id) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.all_delete_user_id(user_id);
	}
	

	@Override
	public void update_session(CartDto dto) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.update_session(dto);
	}
	@Override
	public void update_user(CartDto dto) throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.update_user(dto);
	}

	// 새로운 메서드: 세션 장바구니 항목 존재 여부 확인
    public int checkSessionCart(CartDto dto) throws Exception {
        ICartDao dao = sqlSession.getMapper(ICartDao.class);
        return dao.checkSessionCart(dto);
    }
    // 새로운 메서드: 사용자 장바구니 항목 존재 여부 확인
    public int checkUserCart(CartDto dto) throws Exception {
        ICartDao dao = sqlSession.getMapper(ICartDao.class);
        return dao.checkUserCart(dto);
    }
    
    @Override
	public void delete_S(String session_id, String product_code) {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.delete_session(session_id, product_code);
	}
    @Override
	public void delete_U(String user_id, String product_code) {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
		dao.delete_user(user_id, product_code);
	}
    
    @Override
	public List<CartDto> selectAll() throws Exception {
		ICartDao dao=sqlSession.getMapper(ICartDao.class);
	    
		return dao.selectAll();
	}
}
