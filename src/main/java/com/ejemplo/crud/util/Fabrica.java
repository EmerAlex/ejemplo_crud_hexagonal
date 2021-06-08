package com.ejemplo.crud.util;

import com.ejemplo.crud.dominio.dto.PrestamoDTO;
import com.ejemplo.crud.dominio.modelo.Prestamo;
import com.ejemplo.crud.infraestructura.sql.entidades.PrestamoEntidad;

public class Fabrica {

    public static Prestamo DTOaModelo(PrestamoDTO prestamoDTO){

        return new Prestamo(prestamoDTO.getId(), prestamoDTO.getIsbn(), prestamoDTO.getIdentificacionUsuario(), prestamoDTO.getTipoUsuario(), prestamoDTO.getFechaMaximaDevolucion());

    }
    public static PrestamoDTO EntidadaDTO(PrestamoEntidad prestamoEntidad){

        PrestamoDTO prestamoDTO = new PrestamoDTO(prestamoEntidad.getId(), prestamoEntidad.getIsbn(), prestamoEntidad.getIdentificacionUsuario(), prestamoEntidad.getTipoUsuario());
        prestamoDTO.setFechaMaximaDevolucion(prestamoEntidad.getFechaMaximaDevolucion());
        return prestamoDTO;
    }
    public static PrestamoEntidad DTOaEntidad(PrestamoDTO prestamoDTO){

        return new PrestamoEntidad( prestamoDTO.getIsbn(), prestamoDTO.getIdentificacionUsuario(), prestamoDTO.getTipoUsuario(), prestamoDTO.getFechaMaximaDevolucion());

    }

}
