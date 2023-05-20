package com.dhandapani.microservicestutorialaccountsms.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhandapani.microservicestutorialaccountsms.model.Card;
import com.dhandapani.microservicestutorialaccountsms.model.Customer;

@FeignClient("microservices-tutorial-cards-ms") // We have to provide the application name that is registered with the Eureka Server
public interface CardFeignClient {

	@RequestMapping(method=RequestMethod.POST, value="cards/myCards", consumes="application/json")
	List<Card> getCardDetails(@RequestBody Customer customer);
}
