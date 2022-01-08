package com.example.banking.document;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="customers")
public class CustomerDocument {
	@Id
	private String identity;
	@Field(name = "full_name")
	private String fullname;
	@Field(name = "byear")
	private int birthYear; // ByBirthYear
	@Indexed(unique = true)
	private String email;  // ByEmail
	
	private List<Account> accounts; // ByAccountsIban
	// 1. No-arg Constructor: MUST (Spring Data)
	// 2. Setter/Getter: MUST (Spring Data)
	// 3. equals() and hashCode(): MUST (Java)
	// 4. toString() 

	public CustomerDocument() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDocument other = (CustomerDocument) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "CustomerDocument [identity=" + identity + ", fullname=" + fullname + ", birthYear=" + birthYear
				+ ", email=" + email + ", accounts=" + accounts + "]";
	}
	
}
