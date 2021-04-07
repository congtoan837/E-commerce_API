package com.poly.repositories;

import com.poly.model.Cart;
import com.poly.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.CustomerId = :id")
    public Cart getOrderByCustomerId(@Param("id") Integer id);

    @Query(value = "INSERT INTO Order(Customer_Id) values (:id)", nativeQuery = true)
    public Cart insert(@Param("id") Integer id);
}
