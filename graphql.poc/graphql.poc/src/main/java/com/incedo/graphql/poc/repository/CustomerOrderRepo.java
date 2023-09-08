package com.incedo.graphql.poc.repository;

import com.incedo.graphql.poc.model.Customer;
import com.incedo.graphql.poc.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Integer>  {

//    List<CustomerOrder> findAllByCustomer(List<Customer> customer);

    List<CustomerOrder> findAllByCustomerIn(List<Customer> customers);
}
