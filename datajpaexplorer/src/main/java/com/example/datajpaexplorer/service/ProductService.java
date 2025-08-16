package com.example.datajpaexplorer.service;

import com.example.datajpaexplorer.model.Product;
import com.example.datajpaexplorer.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public List<Product> all() { return repo.findAll(); }

    public Product one(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    }

    @Transactional
    public Product create(Product p) { return repo.save(p); }

    @Transactional
    public Product update(Long id, Product p) {
        Product existing = one(id);
        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        existing.setCategory(p.getCategory());
        return repo.save(existing);
    }

    @Transactional
    public void delete(Long id) { repo.deleteById(id); }

    public List<Product> byCategory(String category) { return repo.findByCategoryIgnoreCase(category); }

    public List<Product> byPriceRange(double min, double max) { return repo.findByPriceBetween(min, max); }

    public Page<Product> search(String q, Pageable pageable) {
        return repo.findByNameContainingIgnoreCase(q, pageable);
    }
}