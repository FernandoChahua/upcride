package com.myorg.upcride.service;

import com.myorg.upcride.model.Solicitud;

import java.util.List;

public interface SolicitudService{
	Solicitud guardarSolicitud(Solicitud s);
    List<Solicitud> listarSolicitudesPorConductor(Integer conductorId) throws Exception;
    int actualizarConfirmacionConductor(String confirmacionConductor, Integer solicitudId) throws Exception;
}
