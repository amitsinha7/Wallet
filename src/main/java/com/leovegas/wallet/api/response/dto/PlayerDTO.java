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

	private AccountDTO accountDTO;

	private List<TransactionDTO> transactionDTOs;

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

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public List<TransactionDTO> getTransactionDTOs() {
		return transactionDTOs;
	}

	public void setTransactionDTOs(List<TransactionDTO> transactionDTOs) {
		this.transactionDTOs = transactionDTOs;
	}

}