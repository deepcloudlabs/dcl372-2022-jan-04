package com.example.banking.dto;

public class TransferRequest {
	private String fromIdentity;
	private String fromIban;
	private String toIdentity;
	private String toIban;
	private double amount;
    // No-arg Constructor
	// Setter/Getter
	
	public TransferRequest() {
	}

	public String getFromIdentity() {
		return fromIdentity;
	}

	public void setFromIdentity(String fromIdentity) {
		this.fromIdentity = fromIdentity;
	}

	public String getFromIban() {
		return fromIban;
	}

	public void setFromIban(String fromIban) {
		this.fromIban = fromIban;
	}

	public String getToIdentity() {
		return toIdentity;
	}

	public void setToIdentity(String toIdentity) {
		this.toIdentity = toIdentity;
	}

	public String getToIban() {
		return toIban;
	}

	public void setToIban(String toIban) {
		this.toIban = toIban;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferRequest [fromIdentity=" + fromIdentity + ", fromIban=" + fromIban + ", toIdentity=" + toIdentity
				+ ", toIban=" + toIban + ", amount=" + amount + "]";
	}

}
