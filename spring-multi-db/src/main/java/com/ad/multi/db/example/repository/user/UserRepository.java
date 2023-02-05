package com.ad.multi.db.example.repository.user;


import com.ad.multi.db.example.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {
}
