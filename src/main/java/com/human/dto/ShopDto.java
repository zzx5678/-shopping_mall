package com.human.dto;


public class ShopDto {
	private String img_address;
	private String code; 
	private String name; 
	private int price;
	private String product_Text; 
	private String manufacturer;
	private String classify;
	private int stock; 
	private String quality;
	
	@Override
	public String toString() {
		return "ShopDto [img_address=" + img_address + ", code=" + code + ", name=" + name + ", price=" + price
				+ ", product_Text=" + product_Text + ", manufacturer=" + manufacturer + ", classify=" + classify
				+ ", stock=" + stock + ", quality=" + quality + "]";
	}


	public String getImg_address() {
		return img_address;
	}
	public void setImg_address(String img_address) {
		this.img_address = img_address;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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

	public String getProduct_Text() {
		return product_Text;
	}
	public void setProduct_Text(String product_Text) {
		this.product_Text = product_Text;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
}
