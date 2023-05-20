package com.dhandapani.microservicestutorialaccountsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhandapani.microservicestutorialaccountsms.config.AccountsServiceConfig;
import com.dhandapani.microservicestutorialaccountsms.model.Account;
import com.dhandapani.microservicestutorialaccountsms.model.Card;
import com.dhandapani.microservicestutorialaccountsms.model.Customer;
import com.dhandapani.microservicestutorialaccountsms.model.CustomerDetail;
import com.dhandapani.microservicestutorialaccountsms.model.Loan;
import com.dhandapani.microservicestutorialaccountsms.model.Properties;
import com.dhandapani.microservicestutorialaccountsms.repository.AccountRepository;
import com.dhandapani.microservicestutorialaccountsms.service.client.CardFeignClient;
import com.dhandapani.microservicestutorialaccountsms.service.client.LoanFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(path = "/accounts/")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountsServiceConfig accountsServiceConfig;

	@Autowired
	private CardFeignClient cardFeignClient;
	@Autowired
	private LoanFeignClient loanFeignClient;

	@PostMapping(path = "/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		Account foundAccount = this.accountRepository.findCustomerByCustomerId(customer.getCustomerId());
		if (foundAccount != null) {
			return foundAccount;
		} else {
			return null;
		}
	}
	
	// API to check another Microservice invocation from a MicroService using Feign Client
	@PostMapping(path = "myCustomerDetail")
	public CustomerDetail myCustomerDetail(@RequestBody Customer customer) {
		Account account = this.accountRepository.findCustomerByCustomerId(customer.getCustomerId());
		List<Loan> loans = this.loanFeignClient.getLoanDetails(customer);
		List<Card> cards = this.cardFeignClient.getCardDetails(customer);
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setAccounts(account);
		customerDetail.setCards(cards);
		customerDetail.setLoans(loans);
		return customerDetail;
	}

	@GetMapping(path = "/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsServiceConfig.getMsg(), accountsServiceConfig.getBuildVersion(),
				accountsServiceConfig.getMailDetails(), accountsServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}
}
