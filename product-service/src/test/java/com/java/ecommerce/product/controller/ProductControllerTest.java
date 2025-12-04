package com.java.ecommerce.product.controller;

import com.java.ecommerce.product.entity.Product;
import com.java.ecommerce.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllProducts() throws Exception {
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Laptop", "Gaming Laptop", 1500.0),
                new Product(2L, "Phone", "Smartphone", 800.0)
        );

        when(service.getAllProducts()).thenReturn(mockProducts);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[1].name").value("Phone"));
    }
}
