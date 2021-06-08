package com.ejemplo.crud.dominio.excepcion;

public class ExcepcionUsuario extends  RuntimeException{

    private static  final  long serialVersionUID = 1L;

    public  ExcepcionUsuario(String mensaje){
        super(mensaje);
    }
}
