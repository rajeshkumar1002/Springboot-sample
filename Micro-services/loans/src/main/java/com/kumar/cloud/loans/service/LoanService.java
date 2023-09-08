package com.kumar.cloud.loans.service;

import com.kumar.cloud.loans.model.Loan;
import com.kumar.cloud.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoanByCustomerId(Long customerId) {
        return loanRepository.findAllByCustomerId(customerId);
    }
}
