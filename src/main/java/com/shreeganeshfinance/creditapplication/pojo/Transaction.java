package com.shreeganeshfinance.creditapplication.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "amount")
    double amount;
    @Column(name = "type")
    String type;
    @Column(name = "account_number")
    long accountNumber;
    @Column(name = "timestamp")
    LocalDateTime timestamp;

    
}
