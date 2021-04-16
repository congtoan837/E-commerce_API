package com.poly.repositories;

import com.poly.model.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Promotion;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {
    @Query("SELECT p FROM Promotion p where p.Coupon = :id")
    Promotion getByCoupon(@Param("id") String id);
}
