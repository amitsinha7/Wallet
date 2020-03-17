package com.leovegas.wallet.api.response.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PlayerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdDate;

	private String name;

	private String sex;

	private AccountDTO account;

	private List<TransactionDTO> transactions;

	public PlayerDTO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public List<TransactionDTO> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}

}