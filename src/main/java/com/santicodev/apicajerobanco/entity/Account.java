package com.santicodev.apicajerobanco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_account",
        uniqueConstraints = @UniqueConstraint(
                name = "iban_unique",
                columnNames = "iban"
        )
)
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long accountId;

    @Column(
            name = "iban",
            nullable = false
    )
    private String iban;

    @Column(
            name = "balance",
            nullable = false
    )
    private int balance;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"

    )
    private Client client;
}
