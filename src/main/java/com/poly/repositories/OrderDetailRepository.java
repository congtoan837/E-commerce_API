package com.poly.repositories;

import com.poly.model.OrderDetailsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.OrderDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetails, Integer> {
    @Query("SELECT new com.poly.model.OrderDetailsDTO(od.Id, p , od.Quantity, (p.Price*od.Quantity)-(pm.percents),  od.Promotion, od.Status, od.PaymentId, od.CreateTime) FROM OrderDetails od "
            + "inner join Product p on od.ProductId = p.Id "
            + "inner join Promotion pm on pm.Coupon = '' where od.OrderId = :id")
    public List<OrderDetailsDTO> getByOrderId(@Param("id") Integer id);

}
