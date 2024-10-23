package com.human.dto;



public class CartShopDto {
	private String cart_id;
	private String session_id; 
	private String user_id; 
	private String product_code;
	private int quantity;
	
	private String name; 
	private int price;
	
	private int totalPrice;
	
	public CartShopDto() {}
	
	public CartShopDto(String cart_id, String session_id, String user_id, String product_code, int quantity, String name, int price) {
		super();
		this.cart_id = cart_id;
		this.session_id = session_id;
		this.user_id = user_id;
		this.product_code = product_code;
		this.quantity = quantity;
		
		this.name = name;
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "CartShopDto [cart_id=" + cart_id + ", session_id=" + session_id + ", user_id=" + user_id
				+ ", product_code=" + product_code + ", quantity=" + quantity + ", name=" + name + ", price=" + price
				+ ", totalPrice=" + totalPrice + "]";
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

	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return this.quantity * this.price;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
}
