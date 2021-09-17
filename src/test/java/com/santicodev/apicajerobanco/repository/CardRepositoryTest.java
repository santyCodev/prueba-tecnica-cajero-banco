package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.entity.Client;
import com.santicodev.apicajerobanco.service.CardService;
import com.santicodev.apicajerobanco.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    private CardService cardService;

    @Test
    public void saveCard() {
        Client client1 = Client
                .builder()
                .firstName("Pepe")
                .lastName("Garcia")
                .cardId("46679532L")
                .build();

        Account account1 = Account
                .builder()
                .iban("ES0012345556789000")
                .balance(5000)
                .client(client1)
                .build();

        cardService.addCard(account1, Constants.CREDIT_CARD);
    }

    /*@Test
    public void getCard() {
        Card card = cardService.findCard(2);

        System.out.println("Card = "+ card);
    }

    @Test
    public void activateCard() {
        Card card = cardService.findCard(1);
        if(card != null){
            cardService.activateCard(card);
        }
    }*/

}