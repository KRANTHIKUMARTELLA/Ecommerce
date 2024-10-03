package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private Integer price;
	private String productPic;
	private Integer productQuantity;
	@ManyToOne
	private Catogery catogery;
	
	
	


	public Product(String productName, Integer price, String productPic, Integer productQuantity, Catogery catogery) {
		super();
		this.productName = productName;
		this.price = price;
		this.productPic = productPic;
		this.productQuantity = productQuantity;
		this.catogery = catogery;
	}

	

	public Product(Integer productId, String productName, Integer price, String productPic, Integer productQuantity,
			Catogery catogery) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productPic = productPic;
		this.productQuantity = productQuantity;
		this.catogery = catogery;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
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


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getProductPic() {
		return productPic;
	}


	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}


	public Integer getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	


	public Catogery getCatogery() {
		return catogery;
	}



	public void setCatogery(Catogery catogery) {
		this.catogery = catogery;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", productPic="
				+ productPic + ", productQuantity=" + productQuantity + ", catogery=" + catogery + "]";
	}



	
	

}
