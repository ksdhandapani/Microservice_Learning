package com.dhandapani.microservicestutorialloansms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhandapani.microservicestutorialloansms.config.LoansServiceConfig;
import com.dhandapani.microservicestutorialloansms.model.Customer;
import com.dhandapani.microservicestutorialloansms.model.Loan;
import com.dhandapani.microservicestutorialloansms.model.Properties;
import com.dhandapani.microservicestutorialloansms.repository.LoanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(path = "/loans")
public class LoanController {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private LoansServiceConfig loansServiceConfig;

	@PostMapping(path = "/myLoans")
	public List<Loan> getLoanDetails(@RequestBody Customer customer) {
		List<Loan> loans = this.loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}
	}

	@GetMapping(path = "/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansServiceConfig.getMsg(), loansServiceConfig.getBuildVersion(),
				loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
