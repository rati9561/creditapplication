package com.shreeganeshfinance.creditapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shreeganeshfinance.creditapplication.pojo.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {


}
