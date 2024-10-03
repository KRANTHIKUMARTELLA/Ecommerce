package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.requestwrapper.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	public List<Product> getAllProducts() {

		return (List<Product>)productRepository.findAll();
	}

	public Product getProductById(Integer id) {

		return productRepository.findById(id).get();

	}

	public Product createProduct(ProductRequest productRequest) {
         Product product = new Product();
		 product.setProductQuantity(productRequest.getProductQuantity());
		 product.setProductName(productRequest.getProductName());
		 product.setProductPic(productRequest.getProductPic());
		 product.setPrice(productRequest.getPrice());
		 product.setCatogery(product.getCatogery());

		return productRepository.save(product);
	}

	public Product updateProduct(Integer id, ProductRequest productDetails) {

		Product product = getProductById(id);
		product.setProductName(productDetails.getProductName());
		product.setPrice(productDetails.getPrice());
		product.setProductPic(productDetails.getProductPic());
		product.setProductQuantity(productDetails.getProductQuantity());
		product.setCatogery(productDetails.getCatogery());
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		Product product = getProductById(id);
		productRepository.delete(product);
	}
}
