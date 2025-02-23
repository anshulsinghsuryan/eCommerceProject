package com.ecommerce.orderService.repository;

import com.ecommerce.orderService.models.OrderDetails;
import com.ecommerce.orderService.models.OrderItem;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
