package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Account;
import com.santicodev.apicajerobanco.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findCardByCardId(Long cardId);

    List<Card> findAllByAccount(Account account);
}
