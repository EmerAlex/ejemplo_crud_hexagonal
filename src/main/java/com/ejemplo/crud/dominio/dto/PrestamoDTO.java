package com.ejemplo.crud.dominio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestamoDTO {
    private String id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private LocalDate fechaMaximaDevolucion;


    public PrestamoDTO() {
        //Empty for Framework.
    }


    public PrestamoDTO(String id, String isbn, String identificacionUsuario, Integer tipoUsuario) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
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



	public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
    
    

}
