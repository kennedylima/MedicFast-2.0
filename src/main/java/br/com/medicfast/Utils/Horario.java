package br.com.medicfast.Utils;

import br.com.medicfast.Ocorrencia.Ocorrencia;

import java.sql.Time;
import java.util.Calendar;

public class Horario {

    public static Time deAtendimentoPara(Ocorrencia ocorrencia){
        Calendar calendar = Calendar.getInstance();
        java.sql.Time horarioAtual = new  java.sql.Time(calendar.getTimeInMillis());
        Time hora = Time.valueOf(horarioAtual.toString());

        calendar.setTime(hora);
        calendar.add(Calendar.MINUTE,ocorrencia.getTempoNecessarioParaOAtendimento());

        horarioAtual = new java.sql.Time(calendar.getTime().getTime());
        return horarioAtual;
    }
}
