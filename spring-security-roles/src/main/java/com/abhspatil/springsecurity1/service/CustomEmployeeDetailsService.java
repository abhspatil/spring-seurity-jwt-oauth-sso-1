package com.abhspatil.springsecurity1.service;

import com.abhspatil.springsecurity1.model.CustomEmployeeDetails;
import com.abhspatil.springsecurity1.model.Employee;
import com.abhspatil.springsecurity1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Employee> optionalUser = employeeRepository.findByFullName(name);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));

        return optionalUser
                .map(CustomEmployeeDetails::new).get();
    }
}
