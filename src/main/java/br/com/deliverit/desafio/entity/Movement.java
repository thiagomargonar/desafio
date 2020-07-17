package br.com.deliverit.desafio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
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

    private String name;

    private BigDecimal value;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expired;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date payment;
}
