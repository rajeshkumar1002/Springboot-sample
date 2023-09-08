package com.incedo.graphql.poc.controller;

import com.incedo.graphql.poc.model.Account;
import com.incedo.graphql.poc.model.AccountType;
import com.incedo.graphql.poc.model.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class AccountController {

    @SchemaMapping
    public Account account(Customer customer){
        return new Account(1, ThreadLocalRandom.current().nextInt(1,10000), AccountType.CURRENT);
    }
}
