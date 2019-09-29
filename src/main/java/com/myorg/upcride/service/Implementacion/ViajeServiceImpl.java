package com.myorg.upcride.service.Implementacion;


import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;
import com.myorg.upcride.repository.AutoRepository;

import com.myorg.upcride.repository.SolicitudRepository;
import com.myorg.upcride.repository.UsuarioRepository;
import com.myorg.upcride.repository.ViajeRepository;
import com.myorg.upcride.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ViajeServiceImpl implements ViajeService {

    ViajeRepository viajeRepository;
    AutoRepository autoRepository;
    UsuarioRepository usuarioRepository;
    SolicitudRepository solicitudRepository;

    @Autowired
    public ViajeServiceImpl(ViajeRepository viajeRepository, AutoRepository autoRepository, UsuarioRepository usuarioRepository, SolicitudRepository solicitudRepository) {
        this.viajeRepository = viajeRepository;
        this.autoRepository = autoRepository;
        this.usuarioRepository = usuarioRepository;
        this.solicitudRepository = solicitudRepository;
    }


    @Override
    public Viaje publicarViaje(Viaje v, Integer conductorId)  {
        v.setEstado("Publicado");
        v.setConductor(usuarioRepository.findById(conductorId).get());
        v.setNumeroPasajeros(0);
        return viajeRepository.save(v);
    }


    @Override
    public Viaje buscarViaje(Integer id) {
        return viajeRepository.findById(id).get();
    }

    @Override
    public List<Viaje> visualizarViajes()  {
        return viajeRepository.findAll();
    }
    @Override
    public int actualizarEstado(String estado, int id) {
        return viajeRepository.actualizarEstado(estado, id);
    }

    @Override
    public int actualizarNumeroDePasajeros(Integer id) {
       int resultado = viajeRepository.calcularNumerodePasajerosDelViaje(id);
       return viajeRepository.actualizarNumeroPasajeros(resultado, id);
    }

    @Override
    public List<Viaje> listarViajesPorConductor(Integer conductorId) {
        return viajeRepository.listarViajesPorConductor(conductorId);
    }
    
    // Logica para Listar Viajes cercanos a mi
    @Override
    public double computeDistance(double latA,double longA,double latB,double longB){
        double R = 6137;
        double dLat = Math.toRadians(latB-latA);
        double dLong = Math.toRadians(longB-longA);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))*Math.sin(dLong/2)*Math.sin(dLong/2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double d = R*c;
        return d;
    }
    
    
    @Override
    public boolean comprobarConductor(Usuario conductor) {
    	boolean valido = true;
    	
    	if(conductor.equals(null))
    		valido = false;
    	else {
    		if (conductor.getRol() != 'C')
    			valido = false;
    		else {
    			if (conductor.getLicenciaConducir() == null)
    				valido = false;
    			else if (autoRepository.buscarAutoPorConductor(conductor.getId()).equals(null))
    				valido = false;
    		}
    	}
        return valido;
    }

    
    public boolean validarLimitesTiempo(Viaje viaje, String razon) {
    	boolean valido = true;
    	
    	LocalDateTime prog = viaje.getProgramadoPara().toLocalDateTime();
    	LocalDateTime cmp = LocalDateTime.now(); 
    	    	
    	switch (razon) {
    	case "Publicar":
    		if (prog.isBefore(cmp.plusHours(1)) || prog.isAfter(cmp.plusHours(24)))
    			valido = false;
    	
    	case "Cancelar":
    		if (viaje.getProgramadoPara().toLocalDateTime().isAfter(cmp.plusHours(1)))
    			valido = false;
    		break;
    	case "Activar":
    		//TODO: activacion
    		
    		break;
    	default:
    		valido = false;
    	}
    	return valido;
    }

	@Override
	public Viaje cancelarViaje(Usuario conductor) {
		
		return null;
	}
    


}

