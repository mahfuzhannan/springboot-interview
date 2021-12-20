package com.mahfuzhannan.javaspringbootinterview.controllers;

import com.mahfuzhannan.javaspringbootinterview.models.Product;
import com.mahfuzhannan.javaspringbootinterview.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        LOGGER.info("Fetching all products");
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        LOGGER.info("Fetching product by id {}", id);
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            return null;
        }
    }
}
