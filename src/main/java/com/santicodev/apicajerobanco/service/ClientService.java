package com.santicodev.apicajerobanco.service;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.entity.Client;
import com.santicodev.apicajerobanco.repository.CardRepository;
import com.santicodev.apicajerobanco.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
}
