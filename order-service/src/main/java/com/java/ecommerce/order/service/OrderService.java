package com.java.ecommerce.order.service;

import com.java.ecommerce.order.client.InventoryClient;
import com.java.ecommerce.order.client.ProductClient;
import com.java.ecommerce.order.entity.Order;
import com.java.ecommerce.order.model.Inventory;
import com.java.ecommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;

    private final ProductClient productClient;

    private final InventoryClient inventoryClient;

    public Order placeOrder(Order order) {

        var product = productClient.getProduct(order.getProductId());
        var inventory = inventoryClient.getInventory(order.getProductId());

        if (inventory.getStock() < order.getQuantity()) {
            order.setStatus("FAILED");
            return repository.save(order);
        }

        inventoryClient.update(
                new Inventory(order.getProductId(),
                        inventory.getStock() - order.getQuantity()));

        order.setTotalPrice(product.getPrice() * order.getQuantity());
        order.setStatus("CREATED");

        return repository.save(order);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }
}
