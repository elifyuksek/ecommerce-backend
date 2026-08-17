package com.elif.ecommercebackend.controller;

import com.elif.ecommercebackend.entity.Card;
import com.elif.ecommercebackend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/card")
@CrossOrigin(origins = "*")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public ResponseEntity<List<Card>> getCards() {
        return ResponseEntity.ok(cardRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        Card saved = cardRepository.save(card);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<Card> updateCard(@RequestBody Card card) {
        Card updated = cardRepository.save(card);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}