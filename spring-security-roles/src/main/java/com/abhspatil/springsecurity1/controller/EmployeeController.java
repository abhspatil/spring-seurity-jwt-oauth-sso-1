package com.abhspatil.springsecurity1.controller;

import com.abhspatil.springsecurity1.model.Employee;
import com.abhspatil.springsecurity1.model.Roles;
import com.abhspatil.springsecurity1.model.UserRoles;
import com.abhspatil.springsecurity1.repository.EmployeeRepository;
import com.abhspatil.springsecurity1.repository.RolesRepository;
import com.abhspatil.springsecurity1.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @GetMapping
    public String home(){
        return "Welcome to Patil's World..!!";
    }

    @PostMapping("/emp")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    public Employee addEmp(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/emp/{id}")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN','ROLES_USER')")
    public Optional<Employee> oneEmp(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/emp")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN','ROLES_USER')")
    public List<Employee> allEmp(){
        return employeeRepository.findAll();
    }

    @PutMapping("/emp")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    public Employee updateEmp(@RequestBody Employee newemployee){
       Optional<Employee> employee = employeeRepository.findById(newemployee.getId());

       employee.orElseThrow(() -> new RuntimeException("User Not found.."));

       employee.get().setSalary(newemployee.getSalary());
       employee.get().setDesignation(newemployee.getDesignation());
       employee.get().setTeam(newemployee.getTeam());
       employee.get().setIsActive(newemployee.getIsActive());
       employee.get().setPassword(newemployee.getPassword());

       return employeeRepository.save(employee.get());
    }

    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    @DeleteMapping("/emp/{id}")
    public void deleteEmp(@PathVariable Integer id){
        employeeRepository.deleteById(id);
    }

    /**
     * Roles
     *
     * @param roles
     * @return
     */
    @PostMapping("/emp/roles")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    public Roles addRoles(@PathVariable Roles roles){
        return rolesRepository.save(roles);
    }

    @GetMapping("/emp/roles")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN','ROLES_USER')")
    public List<Roles> getRoles(){
        return rolesRepository.findAll();
    }

    /**
     * UserRoles
     *
     * @param userRoles
     * @return
     */

    @PostMapping("/emp/userroles")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    public UserRoles putRoles(@PathVariable UserRoles userRoles){
        return userRolesRepository.save(userRoles);
    }

    @GetMapping("/emp/userroles")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN','ROLES_USER')")
    public List<UserRoles> userRoles(){
        return userRolesRepository.findAll();
    }

    @DeleteMapping("/emp/userroles")
    @PreAuthorize("hasAnyRole('ROLES_ADMIN')")
    public void deleteRoles(@PathVariable UserRoles userRoles){
        userRolesRepository.deleteAll();
    }

}
