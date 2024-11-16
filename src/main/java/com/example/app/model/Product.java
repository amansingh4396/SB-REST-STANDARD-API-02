package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer productId;

	private String productName;

	private Double productPrice;

	private String companyName;

	private String productCategory;

	private String productColor;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, Double productPrice, String companyName,
			String productCategory, String productColor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.companyName = companyName;
		this.productCategory = productCategory;
		this.productColor = productColor;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", companyName=" + companyName + ", productCategory=" + productCategory + ", productColor="
				+ productColor + "]";
	}

}
