package com.example.banking.service.business.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {
	private final String iban;

	public AccountNotFoundException(String message, String iban) {
		super(message);
		this.iban = iban;
	}

	public String getIban() {
		return iban;
	}

}
