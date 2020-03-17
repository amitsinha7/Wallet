package com.leovegas.wallet.api.helper;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.leovegas.wallet.api.constant.WalletConstant;
import com.leovegas.wallet.api.request.dto.TransactionRequest;

@Component
public class TransctionValidator {

	public void validateRequest(TransactionRequest transactionRequest, Errors errors, Long playerId) {
		validateTransactionRequest(transactionRequest, errors, playerId);
	}

	private void validateTransactionRequest(TransactionRequest transactionRequest, Errors errors, Long playerId) {
		if (transactionRequest == null || transactionRequest.getAccountTransactionId() == null
				|| transactionRequest.getAccountTransactionId() < 0 || transactionRequest.getAmount() == null
				|| transactionRequest.getAmount() < 0 || transactionRequest.getReference() == null || playerId == null
				|| playerId < 0 || StringUtils.isEmpty(transactionRequest.getReference())
				|| transactionRequest.getTransactionType() == null
				|| !(transactionRequest.getTransactionType().equalsIgnoreCase("C")
						|| transactionRequest.getTransactionType().equalsIgnoreCase("D"))) {
			errors.reject(WalletConstant.WifiServiceError.TRANSACTIONREQUESTMISSING.name());
		}
	}

}
