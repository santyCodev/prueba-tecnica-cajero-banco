package com.santicodev.apicajerobanco.controller;

import com.santicodev.apicajerobanco.entity.Transactions;
import com.santicodev.apicajerobanco.service.CardService;
import com.santicodev.apicajerobanco.service.TransactionService;
import com.santicodev.apicajerobanco.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;

    public TransactionController(TransactionService transactionService, CardService cardService) {
        this.transactionService = transactionService;
        this.cardService = cardService;
    }

    @PostMapping("/{cardId}/{type}/{quantity}")
    public ResponseEntity<Transactions> ejecutarTransaccion(@PathVariable("type") int type,
                                                            @PathVariable("quantity") int quantity,
                                                            @PathVariable("cardId") Long id){
        Transactions newTransaction = transactionService.addTransaction(cardService.findCard(id), type, quantity);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
