package com.kumar.cloud.cards.controller;

import com.kumar.cloud.cards.model.Cards;
import com.kumar.cloud.cards.model.Customer;
import com.kumar.cloud.cards.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {
    @Autowired
    CardsService cardsService;

    @PostMapping
    public List<Cards> getAllCards(@RequestBody Customer customer){
        return cardsService.getAllCards(customer.getCustomerId());
    }

    @PostMapping("/issue")
    public Cards issueCards(@RequestBody Cards card){
        return cardsService.IssueCard(card);
    }
}
