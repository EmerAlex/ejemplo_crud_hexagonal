package com.ejemplo.crud.dominio.modelo;

import java.time.LocalDate;

import com.ejemplo.crud.util.Mensajes;


public class Prestamo {
    private String id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    public static final Integer USUARIO_AFILIADO= 1;
    public static final Integer USUARIO_EMPLEADO= 2;
    public static final Integer USUARIO_INVITADO= 3;

    public static final Integer DIAS_PRESTAMO_USUARIO_AFILIADO= 10;
    public static final Integer DIAS_PRESTAMO_USUARIO_EMPLEADO= 8;
    public static final Integer DIAS_PRESTAMO_USUARIO_INVITADO= 7;


    public Prestamo() {
    }

    public Prestamo(String id, String isbn, String identificacionUsuario, Integer tipoUsuario, LocalDate fechaMaximaDevolucion) {

        ValidarArgumento.validarArgumentoObligatorio(id, Mensajes.ID_PRESTAMO_VACIO);
        this.id = id;

        ValidarArgumento.validarArgumentoObligatorio(isbn, Mensajes.ISBN_PRESTAMO_VACIO);
        ValidarArgumento.validarLongitudArgumento(isbn, Mensajes.LONGITUD_DE_ARGUMENTO_MAXIMA);
        this.isbn = isbn;

        ValidarArgumento.validarArgumentoObligatorio(identificacionUsuario, Mensajes.IDENTIFICACION_USUARIO_PRESTAMO_VACIO);
        ValidarArgumento.validarLongitudArgumento(identificacionUsuario,Mensajes.LONGITUD_DE_ARGUMENTO_MAXIMA);
        this.identificacionUsuario = identificacionUsuario;

        ValidarArgumento.validarArgumentoObligatorio(tipoUsuario,Mensajes.TIPO_USUARIO_PRESTAMO_VACIO);
        this.tipoUsuario = tipoUsuario;

        ValidarArgumento.validarArgumentoObligatorio(fechaMaximaDevolucion,Mensajes.FECHA_MAXIMA_DEVOLUCION_PRESTAMO_VACIA);
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

	public String getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public LocalDate getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}
    
    
}
