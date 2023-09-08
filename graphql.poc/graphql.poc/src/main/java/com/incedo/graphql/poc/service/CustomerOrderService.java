package com.incedo.graphql.poc.service;

import com.incedo.graphql.poc.model.Customer;
import com.incedo.graphql.poc.model.CustomerOrder;
import com.incedo.graphql.poc.repository.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerOrderService {

    @Autowired
    CustomerOrderRepo customerOrderRepo;

    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepo.findAll();
    }
//    public List<CustomerOrder> getOrderByCustomerId(Customer customer){
//        return customerOrderRepo.findAllByCustomer(customer);
//    }

    public List<List<CustomerOrder>> getOrderByCustomers(List<Customer> customers) {

        List<CustomerOrder> list = customerOrderRepo.findAllByCustomerIn(customers);
        Map<Object, List<CustomerOrder>> map = list.stream().collect(Collectors.groupingBy(order -> order.getCustomer().getId()));

        return customers.stream().map(customer -> map.getOrDefault(customer.getId(), Collections.emptyList())).collect(Collectors.toList());
    }
}
