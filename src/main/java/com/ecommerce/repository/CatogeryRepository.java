package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Catogery;
import org.springframework.stereotype.Repository;

@Repository
public interface CatogeryRepository extends CrudRepository<Catogery,Integer> {
	
	

}
