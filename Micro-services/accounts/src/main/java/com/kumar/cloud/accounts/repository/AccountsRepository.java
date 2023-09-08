package com.kumar.cloud.accounts.repository;

import com.kumar.cloud.accounts.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts,Long> {
    public List<Accounts> findAllByCustomerId(Long id);
}
