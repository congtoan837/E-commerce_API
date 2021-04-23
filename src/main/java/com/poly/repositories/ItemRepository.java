package com.poly.repositories;

import com.poly.model.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<CartItem, Integer> {

    @Query("SELECT c FROM CartItem c WHERE c.cart.Id = :id")
    public List<CartItem> getByCartId(@Param("id") Integer id);

    @Query("SELECT c FROM CartItem c WHERE c.product.Id = :ProductId AND c.cart.Id = :CartId")
    public Optional<CartItem> findByProductIdAndCartId(@Param("ProductId") Integer id, @Param("CartId") Integer CartId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.product.Id = :ProductId AND c.cart.Id = :CartId")
    void deleteByProductIdAndCartId(@Param("ProductId") Integer ProductId, @Param("CartId") Integer CartId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.cart.Id = :CartId")
    void deleteByCartId(@Param("CartId") Integer CartId);
}
