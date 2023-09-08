package com.kumar.cloud.cards.service;

import com.kumar.cloud.cards.model.Cards;
import com.kumar.cloud.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;


    public List<Cards> getAllCards(Long customerId) {
        return cardsRepository.findAllByCustomerId(customerId);
    }

    public Cards IssueCard(Cards card) {
        return cardsRepository.save(card);
    }
}
