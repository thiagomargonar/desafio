package br.com.deliverit.desafio.service.treatment;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.entity.Movement;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class Rules {

    public Movement calculateRules(Accounts accounts){

        br.com.deliverit.desafio.entity.enuns.Rules rulesEnum;

        Movement movement = new Movement();
        movement.setName(accounts.getName());
        movement.setPaymentDate(accounts.getPayment());
        movement.setValue(accounts.getValue());

        DatasDiff df = new DatasDiff();
        movement.setExpiredDay(df.dataDiff(accounts.getPayment(), accounts.getExpired()));

        if(movement.getExpiredDay() > 0 && movement.getExpiredDay() <=3){
            movement.setValueAdjusted(rulesOne(movement.getValue(),movement.getExpiredDay()));
            movement.setRules(rulesENUM.
        }else if(movement.getExpiredDay() > 3 && movement.getExpiredDay() <=5){

        }else if (movement.getExpiredDay() > 5){

        }else{
            movement.setValueAdjusted(movement.getValue());
        }

        return movement;
    }

    private BigDecimal rulesOne(BigDecimal value, Long days){
        value = value.multiply(BigDecimal.valueOf(1.02));
        for(int x=0;x<days;x++){
            value = value.multiply(BigDecimal.valueOf(1.001));
        }
        return value;
    }

    private BigDecimal rulesTwo(BigDecimal value, Long days){
        value = value.multiply(BigDecimal.valueOf(1.03));
        for(int x=0;x<days;x++){
            value = value.multiply(BigDecimal.valueOf(1.002));
        }
        return value;
    }

    private BigDecimal rulesThree(BigDecimal value, Long days){
        value = value.multiply(BigDecimal.valueOf(1.05));
        for(int x=0;x<days;x++){
            value = value.multiply(BigDecimal.valueOf(1.003));
        }
        return value;
    }

}
