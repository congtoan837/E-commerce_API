package com.poly.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
