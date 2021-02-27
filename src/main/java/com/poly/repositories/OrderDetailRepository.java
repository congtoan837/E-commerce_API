package com.poly.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.OrderDetails;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetails, Integer> {

}
