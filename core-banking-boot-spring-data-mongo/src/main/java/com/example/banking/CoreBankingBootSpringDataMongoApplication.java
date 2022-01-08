package com.example.banking;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.banking.document.Account;
import com.example.banking.document.AccountStatus;
import com.example.banking.document.CustomerDocument;
import com.example.banking.repository.CustomerMongoRepository;

@SpringBootApplication
public class CoreBankingBootSpringDataMongoApplication implements ApplicationRunner {
	@Autowired
	private CustomerMongoRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CoreBankingBootSpringDataMongoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		 var jack = new CustomerDocument();
		 jack.setIdentity("69565326260");
		 jack.setFullname("jack bauer");
		 jack.setEmail("jack.bauer@example.com");
		 jack.setBirthYear(1956);
		 var accounts = new ArrayList<Account>();
		 accounts.add(new Account("TR500006259912877769695512", 10_000, AccountStatus.ACTIVE));
		 accounts.add(new Account("TR670006298845544846135199", 20_000, AccountStatus.ACTIVE));
		 accounts.add(new Account("TR060006282729837448422961", 30_000, AccountStatus.ACTIVE));
		 jack.setAccounts(accounts);
		 customerRepository.save(jack);
		 */
		 customerRepository.findAllByBirthYearBetween(1950,1960)
		                   .forEach(System.out::println);
		 customerRepository.findByEmail("jack.bauer@example.com")
		                   .ifPresent(System.out::println);
		 customerRepository.findById("69565326260")
		 				   .ifPresent(System.out::println);
		 customerRepository.findByAccountsIban("TR670006298845544846135199")
		                   .ifPresent(System.out::println);
	}

}
