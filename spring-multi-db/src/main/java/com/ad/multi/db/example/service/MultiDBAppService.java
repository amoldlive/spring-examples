package com.ad.multi.db.example.service;


import com.ad.multi.db.example.entity.product.Product;
import com.ad.multi.db.example.entity.user.User;
import com.ad.multi.db.example.repository.product.ProductRepository;
import com.ad.multi.db.example.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MultiDBAppService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MultiDBAppService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByUserId(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUserByUserId(int userId){
         userRepository.deleteById(userId);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductByProductId(int productId){
        return  productRepository.findById(productId).orElse(null);
    }

    public void deleteProductByProductId(int productId){
        productRepository.deleteById(productId);
    }

}
