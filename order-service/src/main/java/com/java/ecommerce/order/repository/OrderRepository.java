package com.java.ecommerce.order.repository;

import com.java.ecommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }

