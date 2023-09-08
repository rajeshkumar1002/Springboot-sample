package com.kumar.cloud.loans.controller;

import com.kumar.cloud.loans.model.Customer;
import com.kumar.cloud.loans.model.Loan;
import com.kumar.cloud.loans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/create")
    public Loan createLoan(@RequestBody Loan loan){
        return loanService.createLoan(loan);
    }

    @PostMapping
    public List<Loan> getAllLoanByCustomerId(@RequestBody Customer customer){
        return loanService.getAllLoanByCustomerId(customer.getCustomerId());
    }


}
