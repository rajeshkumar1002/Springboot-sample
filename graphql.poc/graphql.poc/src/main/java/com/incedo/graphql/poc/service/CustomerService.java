package com.incedo.graphql.poc.service;

import com.incedo.graphql.poc.model.AgeFilter;
import com.incedo.graphql.poc.model.Customer;
import com.incedo.graphql.poc.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    public List<Customer> getAllCustomers(){
        return  customerRepo.findAll();
    }
    public Customer customerById(Integer id){
        return customerRepo.findById(id).orElse(null);
    }

}
