package com.leovegas.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leovegas.wallet.api.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
