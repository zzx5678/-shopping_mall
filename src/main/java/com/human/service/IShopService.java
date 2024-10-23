package com.human.service;

import java.util.List;

import com.human.dto.ShopDto;


public interface IShopService {
	
	public void insert(ShopDto dto) throws Exception;
	public ShopDto select(String code) throws Exception;
	public List<ShopDto> selectAll() throws Exception;
	
	public void delete(String code) throws Exception;
	
	public void update(ShopDto dto) throws Exception;	
	
}
