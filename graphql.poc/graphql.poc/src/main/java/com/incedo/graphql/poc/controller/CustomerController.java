package com.incedo.graphql.poc.controller;

import com.incedo.graphql.poc.model.Customer;
import com.incedo.graphql.poc.model.CustomerOrder;
import com.incedo.graphql.poc.service.CustomerOrderService;
import com.incedo.graphql.poc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerOrderService customerOrderService;
 
    @QueryMapping
    public List<Customer> customers(){
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public Customer customerById(@Argument Integer id){
        return customerService.customerById(id);
    }

    @QueryMapping
    public List<CustomerOrder> orders(){
        return customerOrderService.getAllOrders();
    }

    @BatchMapping(typeName = "Customer")
    public List<List<CustomerOrder>> orders(List<Customer> customers){
        return customerOrderService.getOrderByCustomers(customers);
    }
}
