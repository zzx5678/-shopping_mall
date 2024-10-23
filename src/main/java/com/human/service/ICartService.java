package com.human.service;

import java.util.List;

import com.human.dto.CartDto;


public interface ICartService {
	public void insert_session(CartDto dto) throws Exception;
	public void insert_user(CartDto dto) throws Exception;
	
	public List<CartDto> selectAll_session() throws Exception;
	public List<CartDto> selectAll_user() throws Exception;
	
	public void all_delete_session_id(String session_id) throws Exception;
	public void all_delete_user_id(String user_id) throws Exception;
	
	public void update_session(CartDto dto) throws Exception;
	public void update_user(CartDto dto) throws Exception;
	
	// 새로운 메서드: 세션 장바구니 항목 존재 여부 확인
	public int checkSessionCart(CartDto dto) throws Exception;
    // 새로운 메서드: 사용자 장바구니 항목 존재 여부 확인
	public int checkUserCart(CartDto dto) throws Exception;
			
	public void delete_S(String session_id, String product_code);
	public void delete_U(String user_id, String product_code);
	
	public List<CartDto> selectAll() throws Exception;
}
