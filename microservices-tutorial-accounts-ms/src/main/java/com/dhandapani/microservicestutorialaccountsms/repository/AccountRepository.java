package com.dhandapani.microservicestutorialaccountsms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhandapani.microservicestutorialaccountsms.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findCustomerByCustomerId(int customerId);
}
