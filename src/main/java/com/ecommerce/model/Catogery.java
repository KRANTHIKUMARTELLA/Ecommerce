package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Catogery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer catogeryId;
	private String catogeryName;
	
	@OneToMany(mappedBy="catogery")
	private List<Product> products=new ArrayList<>();
	

	public Catogery(Integer catogeryId, String catogeryName, List<Product> products) {
		super();
		this.catogeryId = catogeryId;
		this.catogeryName = catogeryName;
		this.products = products;
	}
	
	
	public Catogery(String catogeryName, List<Product> products) {
		super();
		this.catogeryName = catogeryName;
		this.products = products;
	}


	public Catogery() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCatogeryId() {
		return catogeryId;
	}


	public void setCatogeryId(Integer catogeryId) {
		this.catogeryId = catogeryId;
	}


	public String getCatogeryName() {
		return catogeryName;
	}


	public void setCatogeryName(String catogeryName) {
		this.catogeryName = catogeryName;
	}
    
	

	public List<Product> getProducts() {
		return products;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Catogery [catogeryId=" + catogeryId + ", catogeryName=" + catogeryName + ", products=" + products + "]";
	}




	
	
	
	
	

}
