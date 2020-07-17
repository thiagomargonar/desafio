package br.com.deliverit.desafio.service.treatment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatasDiff {

    public Long dataDiff(java.util.Date dataLow, java.util.Date dataHigh){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = dataLow;
        System.out.println (d1);
        Date d2 = dataHigh;
        System.out.println (d2);
        long dt = (d2.getTime() - d1.getTime()) + 3600000;
        return ((dt / 86400000L)*-1);
    }

}
