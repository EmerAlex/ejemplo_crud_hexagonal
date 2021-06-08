package com.ejemplo.crud.infraestructura.sql.entidades;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
public class PrestamoEntidad {

    @Id
    @Column(name="id",nullable = false)
    private String id;

    @Column(name="isbn", length = 10, nullable = false)
    private String isbn;

    @Column(name="identificacionUsuario",length = 10)
    private String identificacionUsuario;

    @Column(name="tipoUsuario",nullable = false)
    private Integer tipoUsuario;

    @Column(name="fechaMaximaDevolucion",nullable = false)
    private LocalDate fechaMaximaDevolucion;


    public PrestamoEntidad() {
    }

    public PrestamoEntidad(String isbn, String identificacionUsuario, Integer tipoUsuario, LocalDate fechaMaximaDevolucion) {
        this.id = UUID.randomUUID().toString();
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto)
            return true;
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        PrestamoEntidad entidad = (PrestamoEntidad) objeto;
        return Objects.equals(id, entidad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
