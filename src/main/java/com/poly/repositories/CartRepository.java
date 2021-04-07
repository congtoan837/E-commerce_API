package com.poly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Cart;

import javax.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c WHERE c.CustomerId = :id")
    public Cart getCartByCustomerId(@Param("id") Integer id);

    @Query(value = "INSERT INTO Cart(Customer_Id) values (:id)", nativeQuery = true)
    public Cart insert(@Param("id") Integer id);
}
