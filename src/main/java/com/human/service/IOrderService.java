package com.human.service;

import java.util.List;


import com.human.dto.OrderDto;


public interface IOrderService {
	public void insert_session(OrderDto dto) throws Exception;
	public void insert_user(OrderDto dto) throws Exception;
	
	public OrderDto select_session(String order_id, String session_id) throws Exception;
	public OrderDto select_session_pw(String order_id, String order_phoneNumber, String order_password) throws Exception;
	public OrderDto select_user(String order_id, String user_id) throws Exception;
	
	public List<OrderDto> selectAll() throws Exception;
}
