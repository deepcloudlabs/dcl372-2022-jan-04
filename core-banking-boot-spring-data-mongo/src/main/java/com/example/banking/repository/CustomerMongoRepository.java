package com.example.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.banking.document.CustomerDocument;

public interface CustomerMongoRepository extends MongoRepository<CustomerDocument, String> {
		List<CustomerDocument> findAllByBirthYear(int year);
		List<CustomerDocument> findAllByBirthYearBetween(int fromYear,int toYear);
		Optional<CustomerDocument> findByEmail(String email);
		Optional<CustomerDocument> findByAccountsIban(String iban);
}
