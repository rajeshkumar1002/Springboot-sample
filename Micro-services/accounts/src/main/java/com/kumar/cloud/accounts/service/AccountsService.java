package com.kumar.cloud.accounts.service;

import com.kumar.cloud.accounts.model.Accounts;
import com.kumar.cloud.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Autowired
    AccountsRepository accountsRepository;
    public List<Accounts> getAllByCustomerId(Long id){
        return accountsRepository.findAllByCustomerId(id);
    }

    public Accounts createAccount(Accounts accounts) {
        return accountsRepository.save(accounts);
    }
}
