package com.santicodev.apicajerobanco;

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

    //Get card by id
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable("id") Long id) {
        Card card = cardService.findCard(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updatePinCard(@RequestBody int newPin, @PathVariable("id") Long id){
        Card cardUpdated = cardService.changePin(newPin, id);
        return new ResponseEntity<>(cardUpdated, HttpStatus.OK);
    }
}
