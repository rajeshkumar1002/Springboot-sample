package com.kumar.cloud.loans.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanNumber;
    private Long customerId;
    private Date startDate = new Date();
    private String loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;
    private Date createDate = new Date();
}
