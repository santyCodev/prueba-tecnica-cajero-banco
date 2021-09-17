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
@Table(name = "tbl_card")
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
    private int cardType;

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

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"

    )
    private Account account;
}
