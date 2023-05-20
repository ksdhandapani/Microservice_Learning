package com.dhandapani.microservicestutorialcardsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhandapani.microservicestutorialcardsms.config.CardsServiceConfig;
import com.dhandapani.microservicestutorialcardsms.model.Card;
import com.dhandapani.microservicestutorialcardsms.model.Customer;
import com.dhandapani.microservicestutorialcardsms.model.Properties;
import com.dhandapani.microservicestutorialcardsms.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping(path = "/cards")
public class CardController {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardsServiceConfig cardsServiceConfig;
	
	@PostMapping(path="myCards")
	public List<Card> getCardDetails(@RequestBody Customer customer) {
		List<Card> cards = this.cardRepository.findByCustomerId(customer.getCustomerId());
		if (cards != null) {
			return cards;
		} else {
			return null;
		}
	}
	
	@GetMapping(path="/properties")
	  public String getPropertyDetails() throws JsonProcessingException
	  {
	    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    Properties properties = new Properties(cardsServiceConfig.getMsg(), cardsServiceConfig.getBuildVersion(), cardsServiceConfig.getMailDetails(), cardsServiceConfig.getActiveBranches());
	    return ow.writeValueAsString(properties);
	  }
}
