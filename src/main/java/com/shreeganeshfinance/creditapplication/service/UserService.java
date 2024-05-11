package com.shreeganeshfinance.creditapplication.service;




import com.shreeganeshfinance.creditapplication.pojo.User;


public interface UserService {
    User saveUser(User user);
    User getUser(Long id);
    User getUser(String id);
    User updateUser(Long id, User user);
    boolean isUserExists(String value);
}
