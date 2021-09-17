package com.santicodev.apicajerobanco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_sequence"
    )
    private Long cardId;

    @Column(
            name = "card_type",
            nullable = false
    )
    private String cardType;

    @Column(
            name = "is_activated",
            nullable = false
    )
    private boolean isActivated;

    @Column(
            name = "pin",
            nullable = false
    )
    private int pin;

    @Column(name = "credit")
    private Long credit;
}
