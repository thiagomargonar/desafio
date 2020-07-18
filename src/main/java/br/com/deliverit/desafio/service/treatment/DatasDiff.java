package br.com.deliverit.desafio.service.treatment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatasDiff {

    public Long dataDiff(java.util.Date dataLow, java.util.Date dataHigh){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = dataLow;
        Date d2 = dataHigh;
        long dt = (d1.getTime() - d2.getTime()) + 3600000;
        System.out.println((dt / 86400000L));
        return ((dt / 86400000L));
    }

}
