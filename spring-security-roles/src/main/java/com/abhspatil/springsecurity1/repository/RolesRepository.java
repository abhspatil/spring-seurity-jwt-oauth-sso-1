package com.abhspatil.springsecurity1.repository;

import com.abhspatil.springsecurity1.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}
