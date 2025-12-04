package com.java.ecommerce.inventory.controller;

import com.java.ecommerce.inventory.controller.InventoryController;
import com.java.ecommerce.inventory.entity.Inventory;
import com.java.ecommerce.inventory.service.InventoryService;
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

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {
    @MockBean
    private InventoryService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllProducts() throws Exception {
        List<Inventory> mockInventory = Arrays.asList(
                new Inventory(1L, 20),
                new Inventory(2L, 10)
        );

        when(service.getAll()).thenReturn(mockInventory);

        mockMvc.perform(get("/inventory"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].stock").value(20))
                .andExpect(jsonPath("$[1].stock").value(10));
    }
}
