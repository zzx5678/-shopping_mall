package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.CartDto;
import com.human.dto.CartShopDto;
import com.human.dto.ShopDto;

public interface ICartShopService {

	public List<CartShopDto> selectAll_CartShop_session(@Param("session_id") String sessionId) throws Exception;
	public List<CartShopDto> selectAll_CartShop_user(@Param("user_id") String userId) throws Exception;
	
	public void delete_session(String session_id, String product_code) throws Exception;
	public void delete_user(String user_id, String product_code) throws Exception;
	
	public List<CartShopDto> selectAll_CartShop() throws Exception;
}
