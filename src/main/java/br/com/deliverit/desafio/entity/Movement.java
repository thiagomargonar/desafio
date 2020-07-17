package br.com.deliverit.desafio.entity;

import br.com.deliverit.desafio.entity.enuns.RulesENUM;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "movement")
public class Movement implements Serializable {

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
    private Long expiredDay;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date paymentDate;

    @NotNull
    @JsonIgnore
    @Enumerated
    private RulesENUM rules;


}
