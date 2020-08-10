package com.mahfuzhannan.javaspringbootinterview.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 1. When user hits endpoint we should return all the products we have
     */
    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(11)));
    }

    /**
     * 2. When user hits endpoint we should only return a single product with that id
     */
    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(equalTo("Cake -Lemon Chiffon")));
    }

    /**
     * 3. When user hits endpoint we should return a 404 status if the product does not exist
     */
    @Test
    void getByIdWhenProductDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/products/0000000"))
                .andExpect(status().isNotFound());
    }

    /**
     * 4. When user hits endpoint with category query parameter,
     * we should only return products with that category
     */
    @Test
    void getAllFilteredByCategory() throws Exception {
        mockMvc.perform(get("/api/products")
                .param("category", "cake")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(equalTo("Cake - Lemon Chiffon")));
    }
}