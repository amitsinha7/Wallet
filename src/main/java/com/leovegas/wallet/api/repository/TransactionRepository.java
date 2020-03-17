package com.leovegas.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leovegas.wallet.api.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
