package com.leovegas.wallet.api.constant;

import java.util.HashMap;
import java.util.Map;

public class WalletConstant {

	public static final String SUCCESS = "Success";
	public static final String FAILED = "Failed";
	public static final String DEBIT = "D";
	public static final String CREDIT = "C";

	public static final Map<String, String> errorStore = new HashMap<String, String>();
	public static final String TRANSACTIONREQUESTMISSING = "TRANSACTIONREQUESTMISSING";

	static {
		errorStore.put("110001", "Something went wrong, please try again later.");
		errorStore.put("110002", "Bad request, please check request.");
		errorStore.put("110003", "Insufficient fund to perform operation.");
		errorStore.put("110004", "Invalid Player ID");
		errorStore.put("110005", "Transaction failed");
		errorStore.put("110006", "Invalid transaction ID provided.");
		errorStore.put("110007", "Invalid Account ID");
		errorStore.put("110008", "Unable To Create Player");
	}

}
