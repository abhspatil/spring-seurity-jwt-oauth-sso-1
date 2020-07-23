package com.abhspatil.springsecurityjwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User {

    @Id
    private int id;

    private String userName;
    private String password;
    private String email;

//    public User(String userName, String password, String email) {
//        this.userName = userName;
//        this.password = password;
//        this.email = email;
//    }
}
