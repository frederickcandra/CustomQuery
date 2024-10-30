package com.example.CustomQuery.repository;

import com.example.CustomQuery.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    // Query Kustom untuk menemukan produk berdasarkan kategori
    @Query("{ 'category': ?0 }")
    List<Product> findByCategory(String category);

    // Query Kustom untuk menemukan produk dengan harga di bawah nilai tertentu
    @Query("{ 'price': { $lt: ?0 } }")
    List<Product> findByPriceLessThan(double price);

    // Query Kustom untuk menemukan produk berdasarkan nama yang mengandung teks tertentu
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Product> findByNameContaining(String name);

}
