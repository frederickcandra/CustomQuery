package com.example.CustomQuery;

import com.example.CustomQuery.model.Product;
import com.example.CustomQuery.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        productRepository.save(new Product("Laptop", 800, "Electronics"));
        productRepository.save(new Product("Smartphone", 500, "Electronics"));
        productRepository.save(new Product("Shoes", 80, "Apparel"));
    }

    @Test
    void findByCategory_ShouldReturnProductsByCategory() {
        // When
        List<Product> electronics = productRepository.findByCategory("Electronics");

        // Then
        assertEquals(2, electronics.size());
        assertTrue(electronics.stream().allMatch(p -> p.getCategory().equals("Electronics")));
    }

    @Test
    void findByPriceLessThan_ShouldReturnProductsBelowPrice() {
        // When
        List<Product> cheapProducts = productRepository.findByPriceLessThan(100);

        // Then
        assertEquals(1, cheapProducts.size());
        assertTrue(cheapProducts.stream().allMatch(p -> p.getPrice() < 100));
    }

    @Test
    void findByPriceMoreThan_ShouldReturnProductsAbovePrice() {
        // When
        List<Product> expensiveProducts = productRepository.findByPriceMoreThan(100);

        // Then
        assertEquals(2, expensiveProducts.size());
        assertTrue(expensiveProducts.stream().allMatch(p -> p.getPrice() > 100));
    }

    @Test
    void findByNameContaining_ShouldReturnProductsWithNameContainingText() {
        // When
        List<Product> result = productRepository.findByNameContaining("Lap");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.get(0).getName().contains("Lap"));
    }
}
