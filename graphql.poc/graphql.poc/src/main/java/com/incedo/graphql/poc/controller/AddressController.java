package com.incedo.graphql.poc.controller;

import com.incedo.graphql.poc.model.Address;
import com.incedo.graphql.poc.model.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController {

    @SchemaMapping
    public Address address(Customer customer){
        return new Address(customer.getName()+" City", customer.getName()+" Street");
    }

}
