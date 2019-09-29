package com.myorg.upcride.test;
import com.myorg.upcride.model.*;
import com.myorg.upcride.repository.*;
import com.myorg.upcride.service.*;
import com.myorg.upcride.service.Implementacion.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;

public class TestModuloViaje {

	
	@InjectMocks
	private SolicitudServiceImpl solicitudService;
	@InjectMocks
	private AutoServiceImpl autoService;
	@InjectMocks
	private ReseñaServiceImpl reseñaService;
	@InjectMocks
	private UsuarioServiceImpl usuarioService;
	@InjectMocks
	private ViajeServiceImpl viajeService;
	
	

	@Test
	public void testDist() {
		//Direccion Plaza San Miguel
		double latitudUser = -12.0768002;
		double longitudUser = -77.0843818;
		//Direccion Parque de Las Leyendas
		double latitudViaje = -12.0701824;
		double longitudViaje = -77.0867147;
		boolean respuesta = false;
		boolean esperado = true;
		if(ViajeServiceImpl.computeDistance(latitudUser,longitudUser,latitudViaje,longitudViaje)<1.5) {
		 respuesta =true;	
		}
		System.out.println(ViajeServiceImpl.computeDistance(latitudUser,longitudUser,latitudViaje,longitudViaje));
		assertEquals(respuesta,esperado);
	}
	
	
	//Este caso de prueba valida si un usuario ya tiene una solicitud enviada
	@Test
	public void testValidarSolicitud() {
		Solicitud s = new Solicitud();
		Solicitud n = new Solicitud();
		s.setConfirmacionConductor("Confirmado");
		n.setConfirmacionConductor("Terminado");
		
		
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		solicitudes.add(s);solicitudes.add(n);solicitudes.add(n);solicitudes.add(n);
		boolean resultado = SolicitudServiceImpl.validarSolicitud(solicitudes);
		boolean esperado = false;
		assertEquals(resultado,esperado);
	}
	/*
	@Test
	public void testGuardarSolicitud()
	{
		Solicitud s = new Solicitud();
		Solicitud n = new Solicitud();
		s.setConfirmacionConductor("Confirmado");
		n.setConfirmacionConductor("Terminado");
		
		
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		solicitudes.add(s);solicitudes.add(n);solicitudes.add(n);solicitudes.add(n);
		
		solicitudes.add(s);solicitudes.add(n);solicitudes.add(n);solicitudes.add(n);
		when(solicitudRepository.findAllByUsuarioId(1)).thenReturn(solicitudes);
		Solicitud resultado = new Solicitud();
		resultado.setId(1);
		Solicitud esperado = resultado;
		resultado = solicitudService.guardarSolicitud(resultado);
		
		
		assertEquals(resultado,esperado);
		
	}*/

}
