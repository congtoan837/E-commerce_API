package com.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.Product;
import com.poly.model.ProductDTO;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("select NEW com.poly.model.ProductDTO(a.Id, b.Id, c.Id, a.Name, a.Price, a.Image, a.Description, a.Status, b.Name, a.Quantity, c.Name) from Product as a "
			+ "inner join com.poly.model.Brand as b on a.Brand = b.Id "
			+ "inner join com.poly.model.Category as c on a.Category = c.Id")
	public List<ProductDTO> innerjoin();
}
