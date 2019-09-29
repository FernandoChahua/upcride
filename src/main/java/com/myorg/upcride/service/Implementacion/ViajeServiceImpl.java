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
    public Viaje publicarViaje(Viaje v, Integer conductorId) throws Exception {
        v.setEstado("Publicado");
        v.setVisualizacionHabilitada(1);
        v.setConductor(usuarioRepository.findById(conductorId).get());
        v.setNumeroPasajeros(0);
        return viajeRepository.save(v);
    }


    @Override
    public Viaje buscarViaje(Integer id) throws Exception {
        return viajeRepository.findById(id).get();
    }

    @Override
    public List<Viaje> visualizarViajes() throws Exception {
        return viajeRepository.findAll();
    }

    @Override
    public List<Viaje> filtrar(String puntoPartida, String puntoDestino, Time horaPartida, Time horaLlegada, int entradaSalida, Date fecha) throws Exception {

        if (puntoPartida == null && puntoDestino == null && horaPartida == null && horaLlegada == null && entradaSalida == 2) {
            return viajeRepository.listarPorFecha(fecha);
        }
        else if(puntoPartida == null && puntoDestino == null && horaPartida == null && entradaSalida == 2 && fecha == null){
            return viajeRepository.listarPorHoraLlegada(horaLlegada);
        }
        else if (puntoPartida == null && puntoDestino == null && entradaSalida == 2 && fecha == null) {
            return viajeRepository.listarPorHoraInicioYHoraFin(horaPartida, horaLlegada);
        } else if (horaPartida == null && horaLlegada == null && entradaSalida == 2 && fecha == null) {
            return viajeRepository.listarPorPuntoPartidaYPuntoDestino(puntoPartida, puntoDestino);
        } else if (puntoPartida == null && puntoDestino == null && fecha == null && horaPartida == null && horaLlegada == null) {
            return viajeRepository.listarPorEntradaOSalida(entradaSalida);

        }
       else if (entradaSalida == 2 && fecha == null) {
            return viajeRepository.listarPorPuntoPartidaYPuntoDestinoYHoraInicioYHoraFin(puntoPartida, puntoDestino, horaPartida, horaLlegada);
        } else if (entradaSalida == 2) {

            return viajeRepository.listarPorPuntoPartidaYPuntoDestinoYHoraInicioYHoraFinYFecha( horaPartida, horaLlegada, puntoPartida, puntoDestino, fecha);
        } else {
            return viajeRepository.listarPorTodosLosFiltros(horaPartida, horaLlegada, puntoPartida, puntoDestino, entradaSalida, fecha);

        }
    }
    @Override
    public int actualizarEstado(String estado, int id) throws Exception{
        return viajeRepository.actualizarEstado(estado, id);
    }
    @Override
    public List<Viaje> listarPorSolicitudyPorPasajero(int solicitudId, int pasajeroId) throws Exception{
        return viajeRepository.listarPorSolicitudyPorPasajero(solicitudId, pasajeroId);
    }

    @Override
    public int actualizarNumeroDePasajeros(Integer id) throws Exception{
       int resultado = viajeRepository.calcularNumerodePasajerosDelViaje(id);
       return viajeRepository.actualizarNumeroDePasajeros(resultado,id);
    }

    @Override
    public List<Usuario> listarPasajerosDelViaje(Integer viajeId) throws Exception{
        return viajeRepository.listarPasajerosDelViaje(viajeId);
    }

    @Override
    public List<Solicitud> listarSolicitudesPendientesDelViaje(Integer viajeId) throws Exception{
       return viajeRepository.listarSolicitudesPendientesDelViaje(viajeId);
    }

    @Override
    public List<Solicitud> listarSolicitudesConfirmadasDelViaje(Integer viajeId) throws Exception{
        return viajeRepository.listarSolicitudesConfrimadasDelViaje(viajeId);
    }

    @Override
    public Solicitud solicitarViaje(Integer viajeId, Solicitud s) throws Exception {
        Viaje objViaje = viajeRepository.findById(viajeId).get();
        s.setViaje(objViaje);
        int pasajerosRegistrados = objViaje.getNumeroPasajeros() + 1;
        Solicitud resultado = new Solicitud();
        if (pasajerosRegistrados <= objViaje.getLimitePasajeros()) {
        try {
               resultado = solicitudRepository.save(s);
               viajeRepository.actualizarNumeroDePasajeros(pasajerosRegistrados, objViaje.getId());
        }
        catch (Exception ex)
        {
            throw ex;
        }
        }
        return resultado;
    }

    @Override
    public List<Viaje> listarViajesPorConductor(Integer conductorId) throws Exception{
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
    


}

