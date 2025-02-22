package com.ecommerce.orderService.repository;

import com.ecommerce.orderService.models.OrderItem;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
