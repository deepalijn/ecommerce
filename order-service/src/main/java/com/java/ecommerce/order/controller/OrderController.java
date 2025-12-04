package com.java.ecommerce.order.controller;

import com.java.ecommerce.order.entity.Order;
import com.java.ecommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        return service.placeOrder(order);
    }

    @GetMapping
    public List<Order> getOrders() {

        return service.getOrders();
    }
}