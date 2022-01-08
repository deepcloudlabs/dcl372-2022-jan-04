package com.example.banking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.banking.document.CustomerDocument;

public interface CustomerMongoRepository extends MongoRepository<CustomerDocument, String> {

}
