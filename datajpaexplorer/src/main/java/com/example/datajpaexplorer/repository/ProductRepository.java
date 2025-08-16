package com.example.datajpaexplorer.repository;

import com.example.datajpaexplorer.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived queries (Spring builds SQL by method names)
    List<Product> findByCategoryIgnoreCase(String category);

    List<Product> findByPriceBetween(double min, double max);

    Page<Product> findByNameContainingIgnoreCase(String text, Pageable pageable);
}
