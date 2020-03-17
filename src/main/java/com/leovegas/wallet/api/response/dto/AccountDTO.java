package com.leovegas.wallet.api.response.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long amount;

	private Date createdDate;

	private PlayerDTO player;

	private List<TransactionDTO> transactions;

	public AccountDTO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public PlayerDTO getPlayer() {
		return this.player;
	}

	public void setPlayer(PlayerDTO player) {
		this.player = player;
	}

	public List<TransactionDTO> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}

}