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

import java.sql.Time;
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
        v.setVisualizacionHabilitada(1);
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
    public List<Viaje> listarPorSolicitudyPorPasajero(int solicitudId, int pasajeroId) throws Exception{
        return viajeRepository.listarPorSolicitudyPorPasajero(solicitudId, pasajeroId);
    }

    @Override
    public int actualizarNumeroDePasajeros(Integer id) {
       int resultado = viajeRepository.calcularNumerodePasajerosDelViaje(id);
       return viajeRepository.actualizarNumeroDePasajeros(resultado,id);
    }

    @Override
    public List<Usuario> listarPasajerosDelViaje(Integer viajeId) {
        return viajeRepository.listarPasajerosDelViaje(viajeId);
    }

    @Override
    public List<Solicitud> listarSolicitudesPendientesDelViaje(Integer viajeId) {
       return viajeRepository.listarSolicitudesPendientesDelViaje(viajeId);
    }

    @Override
    public List<Solicitud> listarSolicitudesConfirmadasDelViaje(Integer viajeId) {
        return viajeRepository.listarSolicitudesConfrimadasDelViaje(viajeId);
    }

    @Override
    public List<Viaje> listarViajesPorConductor(Integer conductorId) {
        return viajeRepository.listarViajesPorConductor(conductorId);
    }
    // Logica para Listar Viajes cercanos a mi
    public static double computeDistance(double latA,double longA,double latB,double longB){
        double R = 6137;
        double dLat = Math.toRadians(latB-latA);
        double dLong = Math.toRadians(longB-longA);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))*Math.sin(dLong/2)*Math.sin(dLong/2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double d = R*c;
        return d;
    }
    public static boolean cumpleHora(Viaje viaje)
    {
        boolean cerca=false;



        LocalDateTime HoraActual = LocalDateTime.of(1999, 1, 15, 3, 57, 32, 11);


        if ((viaje.getHoraPartida().getHours() - HoraActual.getHour() == 0  && viaje.getHoraPartida().getMinutes() - HoraActual.getMinute() < 0) ||
            (viaje.getHoraPartida().getHours() - HoraActual.getHour() > 0 && viaje.getHoraPartida().getMinutes() - HoraActual.getMinute() >= 0))
        {
            cerca = true;
        }
        return cerca;
    }

    public static boolean ComprobaarConductor(Usuario conductor)
    {
        boolean esConductor = false;

        conductor.setRol('C');


        if (conductor.getLicenciaConducir() != null)
            esConductor = true;

        return esConductor;
    }
    


}

