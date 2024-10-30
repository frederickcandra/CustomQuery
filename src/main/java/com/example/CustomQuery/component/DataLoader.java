package com.example.CustomQuery.component;

import com.example.CustomQuery.model.Product;
import com.example.CustomQuery.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Hapus semua data yang ada (opsional, agar tidak ada duplikasi data saat aplikasi dijalankan ulang)
        productRepository.deleteAll();

        // Data Dummy
        List<Product> products = Arrays.asList(
                new Product("Laptop", 800, "Electronics"),
                new Product("Smartphone", 500, "Electronics"),
                new Product("Tablet", 300, "Electronics"),
                new Product("Headphones", 50, "Accessories"),
                new Product("Keyboard", 30, "Accessories"),
                new Product("Mouse", 25, "Accessories"),
                new Product("Shoes", 80, "Apparel"),
                new Product("Jacket", 120, "Apparel"),
                new Product("Book", 15, "Books"),
                new Product("Notebook", 5, "Books")
        );

        // Simpan data dummy ke dalam database
        productRepository.saveAll(products);

        System.out.println("Data dummy berhasil ditambahkan!");
    }
}
