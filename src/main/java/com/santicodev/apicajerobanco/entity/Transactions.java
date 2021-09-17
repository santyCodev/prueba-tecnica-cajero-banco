package com.santicodev.apicajerobanco.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_transaction")
public class Transactions {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long transactionId;

    @Column(
            name = "type",
            nullable = false
    )
    private int type;

    @Column(
            name = "quantity",
            nullable = false
    )
    private int quantity;

    @Column(
            name = "date"
    )
    private Date date;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Account account;
}
