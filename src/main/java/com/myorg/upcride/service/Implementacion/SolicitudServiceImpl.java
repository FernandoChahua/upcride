package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.repository.SolicitudRepository;
import com.myorg.upcride.service.SolicitudService;
import com.myorg.upcride.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudRepository solicitudRepository;
    private ViajeService viajeService;
    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository, ViajeService viajeService){
        this.solicitudRepository = solicitudRepository;
        this.viajeService = viajeService;
    }


    @Override
    public Solicitud guardarSolicitud(Solicitud s) throws Exception {
        Solicitud resultado;
        try {
            resultado = solicitudRepository.save(s);
            viajeService.actualizarNumeroDePasajeros(s.getViaje().getId());
        } catch(Exception ex){
            throw ex;
        }

        return resultado;
    }

    @Override
    public List<Solicitud> listarSolicitudes() throws Exception{
        return solicitudRepository.findAll();
    }

    @Override
    public List<Solicitud> listarSolicitudesPorConductor(Integer conductorId) throws Exception{
        return solicitudRepository.listarSolicitudesPorConductor(conductorId);
    }

    @Override
    public int actualizarConfirmacionConductor(String confirmacionConductor, Integer solicitudId) throws Exception{
        return solicitudRepository.actualizarConfirmacionConductor(confirmacionConductor, solicitudId);
    }

}
