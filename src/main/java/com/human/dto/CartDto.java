package com.human.dto;



public class CartDto {
	private String cart_id;
	private String session_id; 
	private String user_id; 
	private String product_code;
	private int quantity;
	
	public CartDto() {
        this.session_id = null; // 초기 값 설정
        this.user_id = null;    // 초기 값 설정
    }


	@Override
	public String toString() {
		return "CartDto [cart_id=" + cart_id + ", session_id=" + session_id + ", user_id=" + user_id + ", product_code="
				+ product_code + ", quantity=" + quantity + "]";
	}


	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
