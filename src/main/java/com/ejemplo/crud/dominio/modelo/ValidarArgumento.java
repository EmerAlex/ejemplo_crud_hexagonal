package com.ejemplo.crud.dominio.modelo;

import com.ejemplo.crud.dominio.excepcion.ExcepcionArgumento;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ValidarArgumento {
	
	

    public static void validarArgumentoObligatorio(Object argumento, String mensaje){

        if(argumento == null || argumento.toString().trim().isEmpty() || Integer.getInteger(argumento.toString())==0){

            throw new ExcepcionArgumento(mensaje);
        }

    }

    public static  void validarLongitudArgumento(Object argumento, String mensaje){

        if (argumento.toString().length()>10){
            throw new ExcepcionArgumento(mensaje);
        }

    }

    public static LocalDate fechaMaxima (int dias) {

        LocalDate fechaMaxima = LocalDate.now();
        var n = 0;

        while (n < dias) {

            if (!fechaMaxima.getDayOfWeek().equals(DayOfWeek.SATURDAY) || !fechaMaxima.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                n++;
            }

            fechaMaxima = fechaMaxima.plusDays(1);


        }
        return fechaMaxima;



    }

}
