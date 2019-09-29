package com.myorg.upcride.test;
import com.myorg.upcride.service.*;
import com.myorg.upcride.service.Implementacion.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.myorg.upcride.service.Implementacion.ViajeServiceImpl;

public class TestModuloViaje {

	
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
	

}
