package com.kumar.cloud.cards.repository;

import com.kumar.cloud.cards.model.Cards;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardsRepository extends CrudRepository<Cards,Long> {
    public List<Cards> findAllByCustomerId(Long customerId);
}
