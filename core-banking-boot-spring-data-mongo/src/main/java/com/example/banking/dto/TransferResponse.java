package com.example.banking.dto;

public class TransferResponse {
	private final String status; // success/failure
	private final String reason;

	public TransferResponse(String status, String reason) {
		this.status = status;
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

}
