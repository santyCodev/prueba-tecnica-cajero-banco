package com.santicodev.apicajerobanco.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "account")
@Table(
        name = "tbl_card",
        uniqueConstraints = @UniqueConstraint(
                name = "num_card_unique",
                columnNames = "num_card"
        )
)
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
            name = "num_card",
            nullable = false
    )
    private String numCard;

    @Column(
            name = "card_type",
            nullable = false
    )
    private int cardType;

    @Column(
            name = "is_active",
            nullable = false
    )
    private boolean isActive;

    @Column(
            name = "pin",
            nullable = false
    )
    private int pin;

    @Column(name = "credit")
    private Integer credit;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"

    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Account account;
}
