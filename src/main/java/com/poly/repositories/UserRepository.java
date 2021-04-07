package com.poly.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	
	@Query("SELECT u FROM Users u WHERE u.Username = :username")
	public Users getByUser(@Param("username") String username);
}
