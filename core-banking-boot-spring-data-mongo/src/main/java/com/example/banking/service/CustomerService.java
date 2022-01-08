package com.example.banking.service;

import com.example.banking.document.CustomerDocument;

public interface CustomerService {

	CustomerDocument findCustomerByIdentity(String identity);

}
