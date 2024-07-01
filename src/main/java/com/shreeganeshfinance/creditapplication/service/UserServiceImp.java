package com.shreeganeshfinance.creditapplication.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shreeganeshfinance.creditapplication.exception.UserAlreadyExistsException;
import com.shreeganeshfinance.creditapplication.exception.UserNotFoundException;
import com.shreeganeshfinance.creditapplication.pojo.Account;
import com.shreeganeshfinance.creditapplication.pojo.User;
import com.shreeganeshfinance.creditapplication.repository.AccountRepository;
import com.shreeganeshfinance.creditapplication.repository.UserRepository;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountRepository accountRepository;

    public User saveUser(User user){
        if(isUserExists(user.getUsername()))
            throw new UserAlreadyExistsException(user.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser =  userRepository.save(user);
        Account account = new Account();
        account.setUser(user);
        account.setBalance(0.00);
        accountRepository.save(account);
        return savedUser;
    }

    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNotFoundException(id);
        }
        
    }

    public User updateUser(Long id, User user){
        user.setId(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setTimeStamp(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return unwrapUser(user, 404L);
    }
    

    public boolean isUserExists(String value) {
        Optional<User> users = userRepository.findByUsername(value);
        if(users.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    static User unwrapUser(Optional<User> entity, Long id){
        if(entity.isPresent()) return entity.get();
        throw new UserNotFoundException(id);
    }

}
