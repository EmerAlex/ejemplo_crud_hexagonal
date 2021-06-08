package com.ejemplo.crud.dominio.dto;


import java.time.LocalDate;


public class RespuestaDTO {
    private String id;
    private LocalDate fechaMaxima;

    public RespuestaDTO() {
        //Empty for Framework.
    }
    public RespuestaDTO(String id, LocalDate fechaMaxima) {
        this.id = id;
        this.fechaMaxima = fechaMaxima;
    }
	public String getId() {
		return id;
	}
	public LocalDate getFechaMaxima() {
		return fechaMaxima;
	}
    
    
}
