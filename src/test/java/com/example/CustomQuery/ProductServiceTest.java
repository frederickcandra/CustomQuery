package com.example.CustomQuery;

import com.example.CustomQuery.model.Product;
import com.example.CustomQuery.repository.ProductRepository;
import com.example.CustomQuery.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts_ShouldReturnAllProducts() {
        // Given
        List<Product> products = Arrays.asList(
                new Product("Laptop", 800, "Electronics"),
                new Product("Shoes", 80, "Apparel")
        );
        when(productRepository.findAll()).thenReturn(products);

        // When
        List<Product> result = productService.getAllProducts();

        // Then
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductsByCategory_ShouldReturnProductsByCategory() {
        // Given
        String category = "Electronics";
        List<Product> products = Arrays.asList(new Product("Laptop", 800, category));
        when(productRepository.findByCategory(category)).thenReturn(products);

        // When
        List<Product> result = productService.getProductsByCategory(category);

        // Then
        assertEquals(products.size(), result.size());
        assertEquals(category, result.get(0).getCategory());
        verify(productRepository, times(1)).findByCategory(category);
    }

    @Test
    void getProductsByPriceLessThan_ShouldReturnProductsBelowPrice() {
        // Given
        double price = 100;
        List<Product> products = Arrays.asList(new Product("Mouse", 25, "Accessories"));
        when(productRepository.findByPriceLessThan(price)).thenReturn(products);

        // When
        List<Product> result = productService.getProductsByPriceLessThan(price);

        // Then
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findByPriceLessThan(price);
    }

    @Test
    void getProductsByPriceMoreThan_ShouldReturnProductsAbovePrice() {
        // Given
        double price = 100;
        List<Product> products = Arrays.asList(new Product("Laptop", 800, "Electronics"));
        when(productRepository.findByPriceMoreThan(price)).thenReturn(products);

        // When
        List<Product> result = productService.getProductsByPriceMoreThan(price);

        // Then
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findByPriceMoreThan(price);
    }

    @Test
    void findByNameContaining_ShouldReturnProductsWithNameContainingText() {
        // Given
        String name = "Lap";
        List<Product> products = Arrays.asList(new Product("Laptop", 800, "Electronics"));
        when(productRepository.findByNameContaining(name)).thenReturn(products);

        // When
        List<Product> result = productService.findByNameContaining(name);

        // Then
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findByNameContaining(name);
    }
}
