package com.java.ecommerce.product.repository;

import com.java.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }

