package com.example.reStore.controller;

import com.example.reStore.models.Product;
import com.example.reStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/api/product")
    public ResponseEntity<?> create(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/product")
    public ResponseEntity<?> findAll() {
        final List<Product> productList = productService.findAll();

        return productList != null && !productList.isEmpty()
                ? new ResponseEntity<>(productList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/product/{id}")
    public ResponseEntity<Optional<Product>> find(@PathVariable(name = "id") Long id) {
        final Optional<Product> product = productService.find(id);

        return product.isPresent()
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/product/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Product> product = productService.find(id);
        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
