package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    private CardRepository repository;

    @Test
    public void saveCard() {
        Account account1 = Account
                .builder()
                .iban("ES00123456789000")
                .balance(5000)
                .build();

        Card card1 = Card
                .builder()
                .cardType(Constants.DEBIT_CARD)
                .isActivated(false)
                .pin(1234)
                .account(account1)
                .build();

        repository.save(card1);
    }

}