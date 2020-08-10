package com.mahfuzhannan.javaspringbootinterview.services;

import com.mahfuzhannan.javaspringbootinterview.models.Product;
import com.mahfuzhannan.javaspringbootinterview.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }
}
