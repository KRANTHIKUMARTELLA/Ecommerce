package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.requestwrapper.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.service.ProductService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {
		Product product=this.productService.createProduct(request);
		 return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @Validated @RequestBody ProductRequest productDetails) {
		Product updatedProduct = productService.updateProduct(id, productDetails);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	

}
