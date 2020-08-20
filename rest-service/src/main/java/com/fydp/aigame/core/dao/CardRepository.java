package com.fydp.aigame.core.dao;

import com.fydp.aigame.core.model.Card;

import java.util.List;

public interface CardRepository {
    void save(Card card);

    Card getRandomCard();

    Card getCardByName(String name);

    Card getCardById(String id);

    List<Card> getAllCards();
}