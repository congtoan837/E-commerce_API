package com.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.Id = :id" )
	public Product getbyId(@Param("id") Integer id);

	@Query("SELECT p FROM Product p WHERE p.Name like %:search% or p.brand.Name like %:search% or p.Category.Name like %:search%")
	public List<Product> getBySearch(@Param("search") String search);

	@Query("SELECT p FROM Product p WHERE p.Price BETWEEN :lower AND :higher")
	public List<Product> getByPrice(@Param("lower") int lower, @Param("higher") int higher);

	@Query("SELECT p FROM Product p WHERE p.Category.Id = :id" )
	public List<Product> getByCategory(@Param("id") Integer id);

	@Query("SELECT p FROM Product p WHERE p.brand.Id = :id" )
	public List<Product> getByBrand(@Param("id") Integer id);

	@Query("SELECT count(p) FROM Product p WHERE p.brand.Id = :id" )
	public int countProductByBrand(@Param("id") Integer id);
}
