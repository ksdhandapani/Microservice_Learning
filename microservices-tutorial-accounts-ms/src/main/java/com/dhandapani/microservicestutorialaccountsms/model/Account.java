package com.dhandapani.microservicestutorialaccountsms.model;

import java.time.LocalDate;

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
@Table(name="accounts")
@Getter
@Setter
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_number")
	private long accountNumber;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="account_type")
	private String accountType;
	@Column(name="branch_address")
	private String branchAddress;
	@Column(name="create_dt")
	private LocalDate createDt;
}
