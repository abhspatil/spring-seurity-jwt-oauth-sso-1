package com.abhspatil.springsecurityoauthsso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class UserController {
    
    @GetMapping
    public String home(){
        return "Welcome to Patil's World..!!";
    }

    @GetMapping("/user")
    public String user(Principal principal){
        return "Welcome "+principal.getName() +"All Securities unlocked..!";
    }
}
