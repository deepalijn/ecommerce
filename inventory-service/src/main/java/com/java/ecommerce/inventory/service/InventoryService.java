package com.java.ecommerce.inventory.service;

import com.java.ecommerce.inventory.entity.Inventory;
import com.java.ecommerce.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository repository;

    public Inventory findByProductId(Long productId) {
        return repository.findById(productId)
            .orElseThrow(() -> new RuntimeException("No inventory found"));
    }

    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAll() {
        return repository.findAll();
    }
}
