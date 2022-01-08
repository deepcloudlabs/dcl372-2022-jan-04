package com.example.banking.service.business.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {
	private final double deficit;

	public InsufficientBalanceException(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}

}
