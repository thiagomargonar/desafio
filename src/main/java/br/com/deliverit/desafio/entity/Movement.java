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

    @NotNull(message = "Nome nao pode estar em branco")
    private String name;

    @NotNull(message = "Valor nao pode estar em branco")
    private BigDecimal value;

    @NotNull(message = "Valor Ajustado nao pode estar em branco")
    @Column(name = "valueAdjusted")
    private BigDecimal valueAdjusted;

    @NotNull(message = "Validade nao pode estar em branco")
    @Column(name = "expiredDay")
    private Long expiredDay;

    @NotNull(message = "data de pagamento nao pode estar em branco")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "paymentDate")
    private Date paymentDate;

    @NotNull(message = "Regra nao pode estar em branco")
    @JsonIgnore
    @Enumerated
    private RulesENUM rules;


}
