package com.myorg.upcride.test;
import com.myorg.upcride.model.*;
import com.myorg.upcride.repository.*;
import com.myorg.upcride.service.*;
import com.myorg.upcride.service.Implementacion.*;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

public class TestModuloViaje {

	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private ReseñaRepository reseñaRepository;
	@Autowired
	private SolicitudRepository solicitudRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ViajeRepository viajeRepository;

	private SolicitudServiceImpl solicitudService;

	private AutoServiceImpl autoService;

	private ReseñaServiceImpl reseñaService;

	private UsuarioServiceImpl usuarioService;

	private ViajeServiceImpl viajeService;
	
	@Before
	public void init() {
		usuarioService = new UsuarioServiceImpl(usuarioRepository);
		autoService = new AutoServiceImpl(autoRepository);
		viajeService = new ViajeServiceImpl(viajeRepository,autoRepository,usuarioRepository,solicitudRepository);
		solicitudService = new SolicitudServiceImpl(solicitudRepository,viajeService);
	}

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
	
	@Test
	public void testGuardarSolicitud()
	{
		Solicitud s = new Solicitud();
		Solicitud n = new Solicitud();
		s.setConfirmacionConductor("Confirmado");
		n.setConfirmacionConductor("Terminado");
		
		
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		solicitudes.add(n);solicitudes.add(n);solicitudes.add(n);solicitudes.add(n);
		
		Solicitud res = new Solicitud();
		res.setId(1);
		boolean esperado = true;
		res = SolicitudServiceImpl.guardarSolicitud(res,solicitudes);
		
		boolean resultado = false;
		if(res!=null) {
			resultado = true;
		}
		
		assertEquals(resultado,esperado);	
	}
	@Test
	public void testValidarConductor() {
		Usuario c = new Usuario();
		c.setRol('C');
		c.setLicenciaConducir("ABC-023");
		boolean resultado = viajeService.comprobarConductor(c);
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	@Test
	public void testCumpleHoraPublicacion() {
		LocalDateTime ldt = LocalDateTime.now();
		Time t =new Time((ldt.getSecond()+ldt.getHour()*3600+ldt.getMinute()*60)*1000);
		Viaje v = new Viaje();
		v.setHoraPartida(t);
		boolean resultado = viajeService.cumpleHora(v);
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	
	

}
