package com.example.banking.service.business.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	private final String identity;

	public CustomerNotFoundException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
