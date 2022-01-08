package com.example.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.document.CustomerDocument;
import com.example.banking.dto.TransferRequest;
import com.example.banking.dto.TransferResponse;

@RestController
@RequestMapping("customers")
public class BankingController {
	
	@GetMapping("{identity}")
	public CustomerDocument getCustomerByIdentity(@PathVariable String identity) {
		return null;
	}
	
	@PostMapping
	public TransferResponse transfer(@RequestBody TransferRequest request) {
		return null;
	}
	
}
