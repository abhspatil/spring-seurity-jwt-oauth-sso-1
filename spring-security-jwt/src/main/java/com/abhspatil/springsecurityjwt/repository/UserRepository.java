package com.abhspatil.springsecurityjwt.repository;

import com.abhspatil.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}