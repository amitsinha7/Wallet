package com.leovegas.wallet.api.helper;

import org.springframework.stereotype.Component;

import com.leovegas.wallet.api.constant.WalletConstant.WifiServiceError;
import com.leovegas.wallet.api.response.dto.ErrorInfo;

@Component
public class Utils {
	
	public ErrorInfo getErrorInfo(WifiServiceError errorMsg) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorMsg.toString());
		errorInfo.setErrorMessage(errorMsg.name());
		return errorInfo;
	}
}
