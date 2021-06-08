package com.ejemplo.crud.infraestructura.sql.persistencia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ejemplo.crud.dominio.dto.PrestamoDTO;
import com.ejemplo.crud.dominio.dto.RespuestaDTO;
import com.ejemplo.crud.dominio.puerto.repositorio.PrestamoRepositorio;
import com.ejemplo.crud.infraestructura.sql.repositorio.PrestamoRepositorioSQL;
import com.ejemplo.crud.util.Fabrica;

@Repository
public class PersistenciaPrestamo implements PrestamoRepositorio {

    private final PrestamoRepositorioSQL prestamoRepositorioSQL;

    public PersistenciaPrestamo(PrestamoRepositorioSQL prestamoRepositorioSQL) {
        this.prestamoRepositorioSQL = prestamoRepositorioSQL;
    }

    @Override
    public List<PrestamoDTO> findAll() {
        return this.prestamoRepositorioSQL.findAll().stream().map(prestamoEntidad ->
                Fabrica.EntidadaDTO(prestamoEntidad)).collect(Collectors.toList());

    }

    @Override
    public List<PrestamoDTO> findBbyIdentificacionUsuario(String identificacionUsaurio) {
        return this.prestamoRepositorioSQL.findByIdentificacionUsuario(identificacionUsaurio).stream().map(prestamoEntidad ->
                Fabrica.EntidadaDTO(prestamoEntidad)).collect(Collectors.toList());
    }

    @Override
    public RespuestaDTO save(PrestamoDTO prestamoDTO) {
    	var prestamoEntidad = Fabrica.DTOaEntidad(prestamoDTO);
        this.prestamoRepositorioSQL.save(prestamoEntidad);
        var prestamo = Fabrica.EntidadaDTO(prestamoEntidad);
        return  new RespuestaDTO(prestamo.getId(),prestamo.getFechaMaximaDevolucion());
    }

    @Override
    public List<PrestamoDTO> finById(String id) {
        return this.prestamoRepositorioSQL.findById(id).stream().map(prestamoEntidad ->
                Fabrica.EntidadaDTO(prestamoEntidad)).collect(Collectors.toList());
    }

	
}

