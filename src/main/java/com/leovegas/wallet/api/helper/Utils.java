package com.leovegas.wallet.api.helper;

import org.springframework.stereotype.Component;

import com.leovegas.wallet.api.constant.WalletConstant;
import com.leovegas.wallet.api.response.dto.ErrorInfo;

@Component
public class Utils {

	public ErrorInfo getErrorInfo(String errorCode) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(WalletConstant.errorStore.get(errorCode));
		return errorInfo;
	}
}
