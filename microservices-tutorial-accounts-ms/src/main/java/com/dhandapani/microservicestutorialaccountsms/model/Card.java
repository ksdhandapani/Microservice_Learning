package com.dhandapani.microservicestutorialaccountsms.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

	private int cardId;

	private int customerId;

	private String cardNumber;

	private String cardType;

	private int totalLimit;

	private int amountUtilized;

	private int availableAmount;

	private Date createDt;

}
