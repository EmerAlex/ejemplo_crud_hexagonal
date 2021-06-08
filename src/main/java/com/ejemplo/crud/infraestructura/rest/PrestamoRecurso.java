package com.ejemplo.crud.infraestructura.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.crud.dominio.dto.PrestamoDTO;
import com.ejemplo.crud.dominio.dto.RespuestaDTO;
import com.ejemplo.crud.dominio.servicio.PrestamoServicio;

@RestController
@RequestMapping("/v1/prestamo")
public class PrestamoRecurso {

    public final PrestamoServicio prestamoServicio;

    public PrestamoRecurso(PrestamoServicio prestamoServicio) {
        this.prestamoServicio = prestamoServicio;
    }

    @GetMapping()
    public List<PrestamoDTO> fidAll(){
       return this.prestamoServicio.finAll();
    }
    
    @PostMapping()
    public RespuestaDTO save (@RequestBody PrestamoDTO prestamo ){
    	return this.prestamoServicio.save(prestamo);
    	
    	
    }
}
