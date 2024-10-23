package com.human.dto;



public class OrderDto {
	private String order_id; 
	private String session_id; 
	private String user_id;
	private String order_name;
	private String order_day;
	private String order_address; 
	private String order_email;
	private String order_phoneNumber;
	private String order_password;
	
	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", session_id=" + session_id + ", user_id=" + user_id
				+ ", order_name=" + order_name + ", order_day=" + order_day + ", order_address=" + order_address
				+ ", order_email=" + order_email + ", order_phoneNumber=" + order_phoneNumber + ", order_password="
				+ order_password + "]";
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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

	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_day() {
		return order_day;
	}

	public void setOrder_day(String order_day) {
		this.order_day = order_day;
	}

	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public String getOrder_email() {
		return order_email;
	}
	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}

	public String getOrder_phoneNumber() {
		return order_phoneNumber;
	}
	public void setOrder_phoneNumber(String order_phoneNumber) {
		this.order_phoneNumber = order_phoneNumber;
	}

	public String getOrder_password() {
		return order_password;
	}
	public void setOrder_password(String order_password) {
		this.order_password = order_password;
	}

	
	
	
}
