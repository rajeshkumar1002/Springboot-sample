package com.kumar.cloud.loans.repository;

import com.kumar.cloud.loans.model.Loan;
import com.kumar.cloud.loans.service.LoanService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Long> {
   public List<Loan> findAllByCustomerId(Long customerId);
}
