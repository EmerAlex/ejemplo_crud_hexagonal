package com.ejemplo.crud.infraestructura.sql.repositorio;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.ejemplo.crud.infraestructura.sql.entidades.PrestamoEntidad;

public interface PrestamoRepositorioSQL extends Repository<PrestamoEntidad,String> {

    List<PrestamoEntidad> findAll();
    
    List<PrestamoEntidad> findByIdentificacionUsuario(String identificacionUsuario);
   
    List<PrestamoEntidad> findById(String id);
    
    void save (PrestamoEntidad prestamo);
    
}
