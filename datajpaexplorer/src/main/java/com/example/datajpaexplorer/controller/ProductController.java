package com.example.datajpaexplorer.controller;

import com.example.datajpaexplorer.model.Product;
import com.example.datajpaexplorer.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> all() { return service.all(); }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) { return service.one(id); }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product p) {
        return ResponseEntity.ok(service.create(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product p) {
        return ResponseEntity.ok(service.update(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Query examples
    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return service.byCategory(category);
    }

    @GetMapping("/price")
    public List<Product> byPriceRange(@RequestParam double min, @RequestParam double max) {
        return service.byPriceRange(min, max);
    }

    @GetMapping("/search")
    public Page<Product> search(@RequestParam String q,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size,
                                @RequestParam(defaultValue = "id") String sort) {
        return service.search(q, PageRequest.of(page, size, Sort.by(sort)));
    }
}
