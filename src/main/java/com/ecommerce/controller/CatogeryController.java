package com.ecommerce.controller;

import com.ecommerce.model.Catogery;
import com.ecommerce.requestwrapper.CatogeryRequest;
import org.springframework.web.bind.annotation.*;


import com.ecommerce.service.CatogeryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CatogeryController {
	private CatogeryService catogeryService;

	public CatogeryController(CatogeryService catogery) {
		super();
		this.catogeryService = catogery;
	}

	@PostMapping("/add")
	public void createCatogery(@RequestBody CatogeryRequest request){
		this.catogeryService.addCatogery(request);
	}

	@GetMapping("/get/{id}")
	public Catogery getCatogery(@PathVariable int id){
		return this.catogeryService.getCatogery(id).get();
	}

	@GetMapping("/getAll")
	public List<Catogery> getAllCatogery(){
		return (List<Catogery>) this.catogeryService.getAllCatogery();
	}

	@DeleteMapping("/delete/{id}")
	public void  deleteCatogery(@PathVariable int id){
		 this.catogeryService.deleteCatogery(id);
	}
}
