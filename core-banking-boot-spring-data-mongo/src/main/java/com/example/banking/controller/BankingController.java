package com.example.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.document.CustomerDocument;
import com.example.banking.dto.TransferRequest;
import com.example.banking.dto.TransferResponse;
import com.example.banking.service.CustomerService;
import com.example.banking.service.TransferService;

@RestController
public class BankingController {
	private CustomerService customerService;
	private TransferService transferService;

	public BankingController(CustomerService customerService, TransferService transferService) {
		this.customerService = customerService;
		this.transferService = transferService;
	}

	@GetMapping("customers/{identity}")
	public CustomerDocument getCustomerByIdentity(@PathVariable String identity) {
		return customerService.findCustomerByIdentity(identity);
	}

	@PostMapping("bank")
	public TransferResponse transfer(@RequestBody TransferRequest request) {
		transferService.transfer(request.getFromIdentity(), request.getFromIban(), request.getToIdentity(),
				request.getToIban(), request.getAmount());
		return new TransferResponse("success", "Transfer is successful");
	}

}
