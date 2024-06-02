package com.shreeganeshfinance.creditapplication.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreeganeshfinance.creditapplication.exception.UserNotFoundException;
import com.shreeganeshfinance.creditapplication.pojo.Account;
import com.shreeganeshfinance.creditapplication.pojo.Transaction;
import com.shreeganeshfinance.creditapplication.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Transaction deposit(Transaction transaction, long acnumber) {
        Account account = accountService.getAccount(acnumber);
        account.setBalance(account.getBalance()+transaction.getAmount());
        accountService.saveAccount(account);
        transaction.setAccount(account);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction withdrawal(Transaction transaction, long acnumber) {
        Account account = accountService.getAccount(acnumber);
        if(account.getBalance() >= transaction.getAmount()){
            account.setBalance(account.getBalance()-transaction.getAmount());
            accountService.saveAccount(account);
            transaction.setAccount(account);
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setType("Withdrawal");
            return transactionRepository.save(transaction);
        }else{
            throw new UserNotFoundException("Amount should be less than or equal to the balance.");
        }
    }
    
}
