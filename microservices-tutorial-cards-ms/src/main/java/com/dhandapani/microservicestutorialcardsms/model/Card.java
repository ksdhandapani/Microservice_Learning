package com.dhandapani.microservicestutorialcardsms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cards")
@Getter
@Setter
@ToString
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="card_id")
	private int cardId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="card_type")
	private String cardType;
	
	@Column(name="total_limit")
	private int totalLimit;
	
	@Column(name="amount_utilized")
	private int amountUtilized;
	
	@Column(name="available_amount")
	private int availableAmount;
	
	@Column(name="create_dt")
	private Date createDt;

}
