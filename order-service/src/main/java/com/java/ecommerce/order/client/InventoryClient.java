package com.java.ecommerce.order.client;

import com.java.ecommerce.order.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
    @GetMapping("/inventory/{productId}")
    Inventory getInventory(@PathVariable Long productId);

    @PostMapping("/inventory/update")
    Inventory update(@RequestBody Inventory inventory);
}
