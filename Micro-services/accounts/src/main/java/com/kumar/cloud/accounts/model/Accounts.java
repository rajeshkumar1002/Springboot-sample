package com.kumar.cloud.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Accounts {
private Long customerId;
@Id
private Long accountNumber;
private String accountType;
private String branchAddress;
private Date createDate = new Date();
}
