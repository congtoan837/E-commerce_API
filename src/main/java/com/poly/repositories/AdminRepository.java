package com.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Admins;

@Repository
public interface AdminRepository extends CrudRepository<Admins, Integer> {

	@Query("SELECT a FROM Admins a WHERE a.Name = ?1 AND a.Password = ?2" )
	List<Admins> login(String Name, String Password);
	
	@Query("SELECT a FROM Admins a WHERE a.Name = :username" )
	public Admins getByName(@Param("username") String username);
}
