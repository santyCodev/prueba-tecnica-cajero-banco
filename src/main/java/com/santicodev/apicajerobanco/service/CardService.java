package com.santicodev.apicajerobanco.service;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.repository.CardRepository;
import com.santicodev.apicajerobanco.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card addCard(Account account, int cardType) {

        Card card = Card
                .builder()
                .numCard("1233456712354566")
                .cardType(checkCardType(cardType))
                .isActive(false)
                .pin(1234)
                .account(account)
                .credit(checkCredit(cardType))
                .build();

        card.setAccount(account);

        return cardRepository.save(card);
    }

    public Card findCard(Long id) {
        return cardRepository.findCardByCardId((long) id);
    }

    public Card changePin(int newPin, Long id) {
        Card card = cardRepository.findCardByCardId(id);
        if(!card.isActive()) {
            card.setPin(newPin);
            updateCard(card);
        }
        return cardRepository.findCardByCardId(card.getCardId());
    }

    public boolean activateCard(Card card) {
        boolean active = false;
        if(!card.isActive()) {
            card.setActive(true);
            updateCard(card);
            active = true;
        }
        return active;
    }

    public Card updateCard(Card card){
        return cardRepository.save(card);
    }

    private int checkCardType(int cardType) {
        if(cardType == Constants.DEBIT_CARD) {
            return Constants.DEBIT_CARD;
        } else {
            return Constants.CREDIT_CARD;
        }
    }

    private Integer checkCredit(int cardType) {
        if(cardType == Constants.DEBIT_CARD) {
            return null;
        } else {
            return Constants.CREDIT_CARD_INITIAL;
        }
    }

}
