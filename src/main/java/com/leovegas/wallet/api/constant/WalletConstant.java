package com.leovegas.wallet.api.constant;

public class WalletConstant {

	public static final String SUCCESS = "Success";
	public static final String FAILED = "Failed";
	public static final String DEBIT = "D";
	public static final String CREDIT = "C";

	public enum WifiServiceError {
		TECHNICAL_ERROR("110001"), MALFORMED_REQUEST("110002"), InsufficientFundException("110003"),
		WalletException("110004"), SOMETHING_WENT_WRONG("110005"), TRANSACTIONREQUESTMISSING("110006");

		private String errorCode;

		private WifiServiceError(String errorCode) {
			this.errorCode = errorCode;
		}

		public String toString() {
			return this.errorCode;
		}
	}
}
