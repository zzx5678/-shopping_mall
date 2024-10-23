package com.human.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.CartDto;
import com.human.dto.CartShopDto;

public interface ICartDao {
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

	public List<CartShopDto> selectAll_CartShop_session(@Param("session_id") String sessionId) throws Exception;
	public List<CartShopDto> selectAll_CartShop_user(@Param("user_id") String userId) throws Exception;
	
	public void delete_session(@Param("session_id") String session_id, @Param("product_code") String product_code);
	public void delete_user(@Param("user_id") String user_id, @Param("product_code") String product_code);
	
	public List<CartDto> selectAll() throws Exception;
	
	public List<CartShopDto> selectAll_CartShop() throws Exception;
}
