package com.java.ecommerce.order.controller;

import com.java.ecommerce.order.entity.Order;
import com.java.ecommerce.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @MockBean
    private OrderService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllOrderss() throws Exception {
        List<Order> mockOrders = Arrays.asList(
                new Order(1L, 1L, 1, 1500.0, "CREATED"),
                new Order(2L, 1L, 1, 800.0, "CREATED")
        );

        when(service.getOrders()).thenReturn(mockOrders);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }
}
