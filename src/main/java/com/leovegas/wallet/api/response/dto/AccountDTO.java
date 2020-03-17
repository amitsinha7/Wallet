package com.leovegas.wallet.api.response.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long amount;

	private Date createdDate;

	private PlayerDTO playerDTO;

	private List<TransactionDTO> transactionDTOs;

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

	public PlayerDTO getPlayerDTO() {
		return playerDTO;
	}

	public void setPlayerDTO(PlayerDTO playerDTO) {
		this.playerDTO = playerDTO;
	}

	public List<TransactionDTO> getTransactionDTOs() {
		return transactionDTOs;
	}

	public void setTransactionDTOs(List<TransactionDTO> transactionDTOs) {
		this.transactionDTOs = transactionDTOs;
	}

}