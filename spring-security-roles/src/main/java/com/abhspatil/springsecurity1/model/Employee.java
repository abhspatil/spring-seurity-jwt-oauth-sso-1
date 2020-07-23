package com.abhspatil.springsecurity1.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String fullName;
    private Double salary;
    private String designation;
    private String team;
    private String isActive;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "userroles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    public Employee(Employee employee) {
        this.Id = employee.getId();
        this.fullName = employee.getFullName();
        this.salary = employee.getSalary();
        this.designation = employee.getDesignation();
        this.team = employee.getTeam();
        this.isActive = employee.getIsActive();
        this.password = employee.getPassword();
        this.roles = employee.getRoles();
    }

    public Employee(String fullName, Double salary, String designation, String team, String isActive, String password, Set<Roles> roles) {
        this.fullName = fullName;
        this.salary = salary;
        this.designation = designation;
        this.team = team;
        this.isActive = isActive;
        this.password = password;
        this.roles = roles;
    }

}
