package com.kumar.cloud.accounts.controller;

import com.kumar.cloud.accounts.model.Accounts;
import com.kumar.cloud.accounts.model.Customer;
import com.kumar.cloud.accounts.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @PostMapping
    public List<Accounts> getAccountDetails(@RequestBody Customer customer){
        return accountsService.getAllByCustomerId(customer.getCustomerId());

    }

    @PostMapping("/create")
    public Accounts createAccount(@RequestBody Accounts accounts){
        return accountsService.createAccount(accounts);

    }

}
