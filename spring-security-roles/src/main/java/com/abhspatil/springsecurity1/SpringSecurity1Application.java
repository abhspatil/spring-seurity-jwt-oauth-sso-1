package com.abhspatil.springsecurity1;

import com.abhspatil.springsecurity1.model.Employee;
import com.abhspatil.springsecurity1.repository.EmployeeRepository;
import com.abhspatil.springsecurity1.repository.RolesRepository;
import com.abhspatil.springsecurity1.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurity1Application {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	UserRolesRepository userRolesRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity1Application.class, args);
	}

}
