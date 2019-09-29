package com.myorg.upcride.service;


import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ViajeService {

    Viaje publicarViaje(Viaje v, Integer conductorId) throws Exception;
    Viaje buscarViaje(Integer id) throws Exception;
    List<Viaje> visualizarViajes() throws Exception;
    int actualizarEstado(String estado, int id) throws Exception;
    int actualizarNumeroDePasajeros(Integer id) throws Exception;
    List<Solicitud> listarSolicitudesPendientesDelViaje(Integer viajeId) throws Exception;
    List<Solicitud> listarSolicitudesConfirmadasDelViaje(Integer viajeId) throws Exception;
    List<Viaje> listarViajesPorConductor(Integer conductor) throws Exception;
    Viaje cancelarViaje(Usuario conductor); 
    
}
