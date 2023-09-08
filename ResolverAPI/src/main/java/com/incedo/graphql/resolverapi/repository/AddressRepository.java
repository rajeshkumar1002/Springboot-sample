package com.incedo.graphql.resolverapi.repository;

import com.incedo.graphql.resolverapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
