package com.shreeganeshfinance.creditapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.shreeganeshfinance.creditapplication.pojo.Account;

public interface AccountRepository extends CrudRepository<Account,Long> {

    
    
} 
