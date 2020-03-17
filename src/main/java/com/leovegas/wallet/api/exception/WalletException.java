package com.leovegas.wallet.api.exception;

public class WalletException extends Exception {

	private static final long serialVersionUID = -2907253767842746242L;

	public WalletException() {
		super();
	}


	public WalletException(String message) {
		super(message);
	}

	public WalletException(Exception e) {
		super(e);
	}

}
