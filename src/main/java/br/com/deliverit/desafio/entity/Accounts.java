package br.com.deliverit.desafio.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "accounts")
public class Accounts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull
    private BigDecimal valueAdjusted;

    @NotNull
    private Date expiration;

    @NotNull
    private Long expirationDays;

}
