package com.example.CustomQuery.controller;

import com.example.CustomQuery.model.Product;
import com.example.CustomQuery.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/category/{ctg}")
    public List<Product> getProductsByCategory(@PathVariable String ctg) {
        return productService.getProductsByCategory(ctg);
    }

    @GetMapping("/price/less/{prc}")
    public List<Product> getProductsByPriceLessThan(@PathVariable double prc) {
        return productService.getProductsByPriceLessThan(prc);
    }

    @GetMapping("/price/more/{prc}")
    public List<Product> getProductsByPriceMoreThan(@PathVariable double prc) {
        return productService.getProductsByPriceMoreThan(prc);
    }

    @GetMapping("/findBy/{contain}")
    public List<Product> getProductsByContain(@PathVariable String contain) {
        return productService.findByNameContaining(contain);
    }
}

