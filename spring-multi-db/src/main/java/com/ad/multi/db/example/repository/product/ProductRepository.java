package com.ad.multi.db.example.repository.product;


import com.ad.multi.db.example.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
