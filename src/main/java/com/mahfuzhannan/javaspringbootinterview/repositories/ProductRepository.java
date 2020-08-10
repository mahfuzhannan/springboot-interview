package com.mahfuzhannan.javaspringbootinterview.repositories;

import com.mahfuzhannan.javaspringbootinterview.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
