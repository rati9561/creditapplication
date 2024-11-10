package com.shreeganeshfinance.creditapplication.web;

import org.springframework.web.bind.annotation.RestController;

import com.shreeganeshfinance.creditapplication.pojo.User;
import com.shreeganeshfinance.creditapplication.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/user")
public class WebController {
    
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getMethodName() {
        return "test";
    }

    @GetMapping("/test")
    public String getHome() {
        return "test";
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> postMethodName(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
    }
        
}
