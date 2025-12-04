package com.java.ecommerce.inventory.controller;

import com.java.ecommerce.inventory.entity.Inventory;
import com.java.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.getAll();
    }

    @GetMapping("/{productId}")
    public Inventory findByProductId(@PathVariable Long productId) {
        return inventoryService.findByProductId(productId);
    }

    @PostMapping("/update")
    public Inventory update(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }
}