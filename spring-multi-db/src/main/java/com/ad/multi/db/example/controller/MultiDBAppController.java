package com.ad.multi.db.example.controller;


import com.ad.multi.db.example.entity.product.Product;
import com.ad.multi.db.example.entity.user.User;
import com.ad.multi.db.example.service.MultiDBAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MultiDBAppController {

    private final MultiDBAppService multiDBAppService;

    @Autowired
    public MultiDBAppController(MultiDBAppService multiDBAppService) {
        this.multiDBAppService = multiDBAppService;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody  User user){
        return multiDBAppService.saveUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return multiDBAppService.getAllUsers();
    }
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable  int userId){
        return multiDBAppService.getUserByUserId(userId);
    }
    @DeleteMapping("/user/{userId}")
    public void deleteUserByUserId(@PathVariable int userId){
        multiDBAppService.deleteUserByUserId(userId);
    }
    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return multiDBAppService.saveProduct(product);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return multiDBAppService.getAllProducts();
    }
    @GetMapping("/product/{productId}")
    public Product getProductByProductId(@PathVariable int productId){
        return  multiDBAppService.getProductByProductId(productId);
    }
    @DeleteMapping("/product/{productId}")
    public void deleteProductByProductId(@PathVariable int productId){
        multiDBAppService.deleteProductByProductId(productId);
    }


}
