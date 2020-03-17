package com.leovegas.wallet.api.response.dto;

import java.util.List;

public class WalletResponseDTO {

	private ErrorInfo errorInfo;

	private PlayerDTO playerDTO;
	private List<TransactionDTO> transactionDTOs;
	private AccountDTO accountDTO;

	public List<TransactionDTO> getTransactionDTOs() {
		return transactionDTOs;
	}

	public void setTransactionDTOs(List<TransactionDTO> transactionDTOs) {
		this.transactionDTOs = transactionDTOs;
	}

	public PlayerDTO getPlayerDTO() {
		return playerDTO;
	}

	public void setPlayerDTO(PlayerDTO playerDTO) {
		this.playerDTO = playerDTO;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

}
