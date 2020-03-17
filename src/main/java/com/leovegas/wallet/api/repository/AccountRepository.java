package com.leovegas.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leovegas.wallet.api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
