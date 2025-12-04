package com.java.ecommerce.inventory.repository;

import com.java.ecommerce.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> { }

