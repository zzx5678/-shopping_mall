package com.human.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.OrderDto;

public interface IOrderDao {
	public void insert_session(OrderDto dto) throws Exception;
	public void insert_user(OrderDto dto) throws Exception;
	
	public OrderDto select_session(@Param("order_id") String order_id, @Param("session_id") String session_id) throws Exception;
	public OrderDto select_session_pw(@Param("order_id") String order_id, @Param("order_phoneNumber") String order_phoneNumber, @Param("order_password") String order_password) throws Exception;
	public OrderDto select_user(@Param("order_id") String order_id, @Param("user_id") String user_id) throws Exception;
	
	public List<OrderDto> selectAll() throws Exception;
}
