package com.santicodev.apicajerobanco.service;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.entity.Transactions;
import com.santicodev.apicajerobanco.repository.CardRepository;
import com.santicodev.apicajerobanco.repository.TransactionRepository;
import com.santicodev.apicajerobanco.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions addTransaction(Card card, int type, int quantity) {

        Transactions newTransaction = Transactions
                .builder()
                .type(checkTransactionType(type))
                .quantity(quantity)
                .date(new Date())
                .account(card.getAccount())
                .build();

        return transactionRepository.save(newTransaction);
    }

    private int checkTransactionType(int type) {
        int transactionType = 0;
        switch (type) {
            case Constants.MOV_INGRESO:
                transactionType = Constants.MOV_INGRESO;
                break;
            case Constants.MOV_RETIRO:
                transactionType = Constants.MOV_RETIRO;
                break;
            case Constants.MOV_TRANS_ENTRANTE:
                transactionType = Constants.MOV_TRANS_ENTRANTE;
                break;
            case Constants.MOV_TRANS_SALIENTE:
                transactionType = Constants.MOV_TRANS_SALIENTE;
                break;
        }
        return transactionType;
    }
}
