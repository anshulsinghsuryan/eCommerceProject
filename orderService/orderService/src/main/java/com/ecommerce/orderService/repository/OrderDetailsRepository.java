package com.ecommerce.orderService.repository;

import com.ecommerce.orderService.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    @Query("Select * from order_items where userId = :userId")
    public List<OrderDetails> getOrderDetailsByUserId(@Param("userId") Long userId);
}
