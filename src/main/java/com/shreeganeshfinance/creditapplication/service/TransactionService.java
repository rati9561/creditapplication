package com.shreeganeshfinance.creditapplication.service;

import com.shreeganeshfinance.creditapplication.pojo.Transaction;

public interface TransactionService {

    Transaction deposit(Transaction transaction, long acnumber);
    Transaction withdrawal(Transaction transaction, long acnumber); 
    
}
