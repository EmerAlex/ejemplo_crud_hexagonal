package com.ejemplo.crud.dominio.puerto.repositorio;

import java.util.List;

import com.ejemplo.crud.dominio.dto.PrestamoDTO;
import com.ejemplo.crud.dominio.dto.RespuestaDTO;

public interface PrestamoRepositorio {


    List<PrestamoDTO> findAll();

    List<PrestamoDTO> findBbyIdentificacionUsuario(String identificacionUsaurio);

    RespuestaDTO save(PrestamoDTO prestamoDTO);

    List <PrestamoDTO> finById(String id);
    
   


}
