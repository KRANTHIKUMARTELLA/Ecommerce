package com.ecommerce.repository;

import java.util.Optional;

import com.ecommerce.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
	
	Optional<Users> findByUsername(String username);

}
