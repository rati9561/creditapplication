package com.shreeganeshfinance.creditapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeganeshfinance.creditapplication.pojo.Account;
import com.shreeganeshfinance.creditapplication.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }


    
}
