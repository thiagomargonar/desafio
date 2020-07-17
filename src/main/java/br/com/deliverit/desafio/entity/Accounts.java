package br.com.deliverit.desafio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Accounts implements Serializable {

    @NotEmpty(message = "Nome nao pode estar em branco")
    private String name;

    @NotEmpty(message = "Valor nao pode estar em branco")
    private BigDecimal value;

    @NotEmpty(message = "Data de validade nao pode estar em branco")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expired;

    @NotEmpty(message = "Data de pagamento nao pode estar em branco")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date payment;
}
