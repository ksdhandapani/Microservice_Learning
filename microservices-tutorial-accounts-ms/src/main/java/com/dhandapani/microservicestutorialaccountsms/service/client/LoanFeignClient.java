package com.dhandapani.microservicestutorialaccountsms.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhandapani.microservicestutorialaccountsms.model.Customer;
import com.dhandapani.microservicestutorialaccountsms.model.Loan;

@FeignClient("microservices-tutorial-loans-ms") // We have to provide the application name that is registered with the Eureka Server
public interface LoanFeignClient {

	@RequestMapping(method=RequestMethod.POST, value="loans/myLoans", consumes="application/json")
	List<Loan> getLoanDetails(@RequestBody Customer customer);
}
