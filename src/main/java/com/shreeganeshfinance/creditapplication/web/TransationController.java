package com.shreeganeshfinance.creditapplication.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganeshfinance.creditapplication.pojo.Account;
import com.shreeganeshfinance.creditapplication.pojo.Transaction;
import com.shreeganeshfinance.creditapplication.service.AccountService;
import com.shreeganeshfinance.creditapplication.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/account/{acnumber}/transaction/")
public class TransationController {

    @Autowired
    private TransactionService transactionService;
    
    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody Transaction transaction, @PathVariable long acnumber) {
        return transactionService.deposit(transaction,acnumber);
    }


    @PostMapping("/withdrawal")
    public Transaction withdrawal(@RequestBody Transaction transaction, @PathVariable long acnumber) {
        return transactionService.withdrawal(transaction,acnumber );
    }
    
}
