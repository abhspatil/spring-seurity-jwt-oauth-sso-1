package com.abhspatil.springsecurity1.repository;

import com.abhspatil.springsecurity1.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles,Integer> {
}
