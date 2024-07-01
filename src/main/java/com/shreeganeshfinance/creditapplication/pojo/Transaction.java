package com.shreeganeshfinance.creditapplication.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name = "timestamp")
    LocalDateTime timestamp;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "accountnumber",referencedColumnName = "account_number")
    private Account account;

    
}
