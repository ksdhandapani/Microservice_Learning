package com.dhandapani.microservicestutorialloansms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhandapani.microservicestutorialloansms.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{

	List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
