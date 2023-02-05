package com.ad.multi.db.example.controller;


import com.ad.multi.db.example.entity.product.Product;
import com.ad.multi.db.example.entity.user.User;
import com.ad.multi.db.example.repository.product.ProductRepository;
import com.ad.multi.db.example.repository.user.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MultiDBController {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public MultiDBController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return null;
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}
