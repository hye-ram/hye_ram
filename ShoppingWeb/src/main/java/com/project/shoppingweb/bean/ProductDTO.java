package com.project.shoppingweb.bean;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

	private int product_id;
	private String product_name;
	private String price;
	private String description;
	private String picture_url;
	private MultipartFile file1; // 첨부파일은 MultipartFile타입으로 저장한다.

	private String cate01Id;
	private String cate01Name;

	private String cate02Id;
	private String cate02Name;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public String getCate01Id() {
		return cate01Id;
	}

	public void setCate01Id(String cate01Id) {
		this.cate01Id = cate01Id;
	}

	public String getCate01Name() {
		return cate01Name;
	}

	public void setCate01Name(String cate01Name) {
		this.cate01Name = cate01Name;
	}

	public String getCate02Id() {
		return cate02Id;
	}

	public void setCate02Id(String cate02Id) {
		this.cate02Id = cate02Id;
	}

	public String getCate02Name() {
		return cate02Name;
	}

	public void setCate02Name(String cate02Name) {
		this.cate02Name = cate02Name;
	}
	
	
	  @Override public String toString() { return "ProductDTO [cate02Id=" +
	  cate02Id + ", product_id=" + product_id + ", product_name=" + product_name +
	  ", price=" + price + ", description=" + description + ", prcture_url=" +
	  picture_url + ", file1=" + file1 + "]"; }
	 
}