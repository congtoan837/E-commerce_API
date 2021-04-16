package com.poly.repositories;

import com.poly.model.CartDTO;
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

    @Query("SELECT new com.poly.model.CartDTO(i.Id,p,i.Quantity) FROM Product p " +
            "Inner join CartItem i on i.ProductId = p.Id WHERE i.CartId = :id")
    public List<CartDTO> getByCartId(@Param("id") Integer id);

    @Query("SELECT p FROM CartItem p WHERE p.ProductId = :ProductId AND p.CartId = :CartId")
    public Optional<CartItem> findByProductIdAndCartId(@Param("ProductId") Integer id, @Param("CartId") Integer CartId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem p WHERE p.ProductId = :ProductId AND p.CartId = :CartId")
    void deleteByProductIdAndCartId(@Param("ProductId") Integer ProductId, @Param("CartId") Integer CartId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem p WHERE p.CartId = :CartId")
    void deleteByCartId(@Param("CartId") Integer CartId);
}
