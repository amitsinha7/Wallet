package com.leovegas.wallet.api.request.dto;

public class TransactionRequest {

	private Long accountTransactionId;
	private String transactionType;
	private Long amount;
	private String reference;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
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

}
