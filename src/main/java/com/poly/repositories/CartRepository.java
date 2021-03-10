package com.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.Cart;
import com.poly.model.CartDTO;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	@Query("select NEW com.poly.model.CartDTO(a.Id, b.Id, b.Name, b.Phone, c.Id, c.Name, c.Image, c.Quantity, a.Quantity) from Cart as a "
			+ "inner join com.poly.model.Customer as b on a.Customer_Id = b.Id "
			+ "inner join com.poly.model.Product as c on a.Product_Id = c.Id")
	public List<CartDTO> innerjoin();
}
