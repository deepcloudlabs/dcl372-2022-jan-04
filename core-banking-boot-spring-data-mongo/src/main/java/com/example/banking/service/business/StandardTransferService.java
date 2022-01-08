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
		//TODO: implement the transfer logic
	}

}
