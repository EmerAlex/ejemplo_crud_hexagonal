package com.ejemplo.crud.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.crud.dominio.dto.PrestamoDTO;
import com.ejemplo.crud.dominio.dto.RespuestaDTO;
import com.ejemplo.crud.dominio.excepcion.ExcepcionUsuario;
import com.ejemplo.crud.dominio.modelo.Prestamo;
import com.ejemplo.crud.dominio.modelo.ValidarArgumento;
import com.ejemplo.crud.dominio.puerto.repositorio.PrestamoRepositorio;
import com.ejemplo.crud.util.Mensajes;


@Service
public class PrestamoServicio {


    private final PrestamoRepositorio prestamoRepositorio;

    public PrestamoServicio(PrestamoRepositorio prestamoRepositorio) {

        this.prestamoRepositorio = prestamoRepositorio;

    }

    public List<PrestamoDTO> finAll (){

        return this.prestamoRepositorio.findAll();

    }

    public  List<PrestamoDTO> findByIdentificacionUsuario(String identificacionUsuario){
        return  this.prestamoRepositorio.findBbyIdentificacionUsuario(identificacionUsuario);
    }

    public List<PrestamoDTO> findById(String id){
        return  this.prestamoRepositorio.finById(id);
    }

    public RespuestaDTO save(PrestamoDTO prestamoDTO){
    
    	validarTipoUsuario(prestamoDTO.getIdentificacionUsuario());
    	PrestamoDTO prestamo = validarFechaMaxima(prestamoDTO);
    	return this.prestamoRepositorio.save(prestamo);
       

    }


    private boolean validarTipoUsuario(String identificacionUsuario){
    	
    	var retorno = false;
    	
    	List<PrestamoDTO> prestamos = this.findByIdentificacionUsuario(identificacionUsuario);
    	
    	if( prestamos == null||prestamos.isEmpty() ) {
    		retorno = true;
    	}else {
    		for (PrestamoDTO prestamo : prestamos) {
				if(prestamo.getTipoUsuario()==3) {
					retorno=true;
					throw new ExcepcionUsuario("El usuario con identificacion " +identificacionUsuario + " ya tiene un libro prestado por lo cual no se le puede realizar otro prestamo");
				}
			}
    	}
    	
    	return retorno;
    	
    }

    private PrestamoDTO validarFechaMaxima(PrestamoDTO prestamoDTO){
    	var prestamo= prestamoDTO; 
        if (prestamo.getTipoUsuario().equals(Prestamo.USUARIO_AFILIADO)){
            prestamo.setFechaMaximaDevolucion(ValidarArgumento.fechaMaxima(Prestamo.DIAS_PRESTAMO_USUARIO_AFILIADO));
        }else if (prestamo.getTipoUsuario().equals(Prestamo.USUARIO_EMPLEADO)){
            prestamo.setFechaMaximaDevolucion(ValidarArgumento.fechaMaxima(Prestamo.DIAS_PRESTAMO_USUARIO_EMPLEADO));
        }else if (prestamo.getTipoUsuario().equals(Prestamo.USUARIO_INVITADO)){
            prestamo.setFechaMaximaDevolucion(ValidarArgumento.fechaMaxima(Prestamo.DIAS_PRESTAMO_USUARIO_INVITADO));
        }else{
                throw new ExcepcionUsuario(Mensajes.TIPO_DE_USUARIO_NO_VALIDO);
        }
        return  prestamo;
    }



}
