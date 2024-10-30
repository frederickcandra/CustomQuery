package com.example.CustomQuery.service;

import com.example.CustomQuery.model.Product;
import com.example.CustomQuery.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByPriceLessThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }
}

