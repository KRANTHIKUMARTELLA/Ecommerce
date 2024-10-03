package com.ecommerce.service;

import com.ecommerce.model.Catogery;
import com.ecommerce.requestwrapper.CatogeryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecommerce.repository.CatogeryRepository;

import java.util.Optional;

@Service
public class CatogeryService {
	@Autowired
	private CatogeryRepository catogeryRepository;

	public CatogeryService(CatogeryRepository catogeryRepository) {
		super();
		this.catogeryRepository = catogeryRepository;
	}

	public void addCatogery(CatogeryRequest request){
		Catogery cat=new Catogery();
		cat.setCatogeryName(request.getCatogeryName());
		this.catogeryRepository.save(cat);
	}

	public Optional<Catogery> getCatogery(int id){
		return this.catogeryRepository.findById(id);
	}

	public Iterable<Catogery>  getAllCatogery(){
		return this.catogeryRepository.findAll();
	}

	public void deleteCatogery(int id){
		 this.catogeryRepository.deleteById(id);
	}
	
	
	
	
}
