package com.leovegas.wallet.api.response.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long amount;

	private Date createdDate;

	private String status;

	private String type;
	
	private String reference;

	private AccountDTO accountDTO;

	private PlayerDTO playerDTO;

	private Long accountTransactionId;

	public TransactionDTO() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAccountTransactionId() {
		return accountTransactionId;
	}

	public void setAccountTransactionId(Long accountTransactionId) {
		this.accountTransactionId = accountTransactionId;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public PlayerDTO getPlayerDTO() {
		return playerDTO;
	}

	public void setPlayerDTO(PlayerDTO playerDTO) {
		this.playerDTO = playerDTO;
	}
}