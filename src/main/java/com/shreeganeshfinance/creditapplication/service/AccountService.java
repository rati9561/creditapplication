package com.shreeganeshfinance.creditapplication.service;

import com.shreeganeshfinance.creditapplication.pojo.Account;

public interface AccountService {

    Account getAccount(long id);
    Account saveAccount(Account account);
    
}
