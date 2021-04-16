package com.poly.repositories;

import com.poly.model.OrderDTO;
import com.poly.model.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o inner join Users u on o.CustomerId = u.Id where o.CustomerId = :id")
    List<Orders> getOrderByCustomerId(@Param("id") Integer id);

    @Query("SELECT NEW com.poly.model.OrderDTO(o.Id, u.Name, u.Phone,o.Address,pm.percents, p.Name, o.Status) FROM Orders o inner join Users u on o.CustomerId = u.Id inner join Payment p on o.PaymentId = p.Id inner join Promotion pm on pm.Coupon = o.Promotion")
    List<OrderDTO> getall();

    @Query(value = "select SUM(od.Quantity) from Order_Details od inner join Orders o on o.id = od.Order_Id inner join Product p on p.Id = od.Product_Id inner join Category c on c.Id = p.Category where c.Name = :category and o.Create_time >= :timestart and o.Create_time <= :timeend", nativeQuery = true)
    int countByTime(@Param("timestart") String timestart, @Param("timeend") String timeend, @Param("category") String category);
}
