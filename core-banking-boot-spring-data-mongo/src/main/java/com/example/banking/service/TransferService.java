package com.example.banking.service;

public interface TransferService {
	void transfer(String fromIdentity,
			      String fromIban,
			      String toIdentity,
			      String toIban,
			      double amount);
}
