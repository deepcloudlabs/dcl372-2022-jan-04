package com.example.banking.document;

import java.util.Objects;

import org.springframework.data.mongodb.core.index.Indexed;

import com.example.banking.service.business.exception.InsufficientBalanceException;

// Alt + Shift + S -> Generates code!
public class Account {
	@Indexed(unique = true)
	private String iban;
	private double balance;
	private AccountStatus status;

	// 1. No-arg Constructor: MUST (Spring Data)
	// 2. Full Constructor
	// 3. Setter/Getter: MUST (Spring Data)
	// 4. equals() and hashCode(): MUST (Java)
	// 5. toString()
	public Account() {
		// Spring Data requires a no-arg constructor!
	}

	public Account(String iban, double balance, AccountStatus status) {
		this.iban = iban;
		this.balance = balance;
		this.status = status;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public void withdraw(double amount) {
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount must be a positive number.");
		if (amount > balance) {
			throw new InsufficientBalanceException("Your balance does not cover the amount", amount - balance);
		}
		balance -= amount;
	}

	public void deposit(double amount) {
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount must be a positive number.");
		balance += amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(iban, other.iban);
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + ", status=" + status + "]";
	}

}
