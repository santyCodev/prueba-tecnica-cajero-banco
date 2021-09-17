package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Client;
import com.santicodev.apicajerobanco.service.CardService;
import com.santicodev.apicajerobanco.service.ClientService;
import com.santicodev.apicajerobanco.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void saveClient() {
        Client client1 = Client
                .builder()
                .firstName("Pepe")
                .lastName("Garcia")
                .cardId("46669532L")
                .build();

        clientService.addClient(client1);
    }
}