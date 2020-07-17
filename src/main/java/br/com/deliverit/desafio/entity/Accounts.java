package br.com.deliverit.desafio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Accounts implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expired;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date payment;
}
