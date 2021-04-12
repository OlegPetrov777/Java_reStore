package com.example.reStore.service;

import com.example.reStore.models.Product;
import com.example.reStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void create(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> find(Long id){
        return productRepository.findById(id);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
