package com.santicodev.apicajerobanco.controller;

import com.santicodev.apicajerobanco.entity.Card;
import com.santicodev.apicajerobanco.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable("id") Long id) {
        Card card = cardService.findCard(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Card> updatePinCard(@RequestBody Card card){
        Card cardUpdated = cardService.changePin(card);
        return new ResponseEntity<>(cardUpdated, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> activateCard(@PathVariable("id") Long id){
        Card cardUpdated = cardService.activateCard(id);
        return new ResponseEntity<>(cardUpdated, HttpStatus.OK);
    }
}
