package com.example.banking.service.business;

import org.springframework.stereotype.Service;

import com.example.banking.repository.CustomerMongoRepository;
import com.example.banking.service.TransferService;
import com.example.banking.service.business.exception.AccountNotFoundException;
import com.example.banking.service.business.exception.CustomerNotFoundException;

@Service
public class StandardTransferService implements TransferService {
	private CustomerMongoRepository customerMongoRepository;

	public StandardTransferService(CustomerMongoRepository customerMongoRepository) {
		this.customerMongoRepository = customerMongoRepository;
	}

	@Override
	public void transfer(String fromIdentity, String fromIban, String toIdentity, String toIban, double amount) {
		var fromCustomer = customerMongoRepository.findById(fromIdentity)
		                       .orElseThrow(() -> new CustomerNotFoundException("Cannot find customer",fromIdentity));
		var toCustomer = customerMongoRepository.findById(toIdentity)
				               .orElseThrow(() -> new CustomerNotFoundException("Cannot find customer",toIdentity));

		var fromAccount = fromCustomer.getAccounts()
				                      .stream()
				                      .filter(account -> account.getIban().equals(fromIban))
				                      .findFirst()
				                      .orElseThrow(() -> new AccountNotFoundException("Cannot find the account",fromIban));
		var toAccount = toCustomer.getAccounts()
				.stream()
				.filter(account -> account.getIban().equals(toIban))
				.findFirst()
				.orElseThrow(() -> new AccountNotFoundException("Cannot find the account",fromIban));
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		customerMongoRepository.save(fromCustomer);
		customerMongoRepository.save(toCustomer);
	}

}
