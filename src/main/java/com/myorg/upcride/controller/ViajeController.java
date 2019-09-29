package com.myorg.upcride.controller;


import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;
import com.myorg.upcride.service.ViajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    private ViajeService viajeService;

    @Autowired
    public ViajeController(ViajeService viajeService){
        this.viajeService = viajeService;
    }

    @RequestMapping
    public List<Viaje> visualizarViajesRegistrados() throws Exception
    {
        return viajeService.visualizarViajes();
    }


    @RequestMapping(path="/conductor/{conductorId}",method = RequestMethod.GET)
    public List<Viaje> listarViajesPorConductor(@PathVariable Integer conductorId) throws Exception{
      return viajeService.listarViajesPorConductor(conductorId);
    }
    @RequestMapping( path="/publicar/{conductorId}",method = RequestMethod.POST)
    public Viaje publicarViaje(@RequestBody Viaje v, @PathVariable Integer conductorId) throws Exception {

        return viajeService.publicarViaje(v, conductorId);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Viaje buscarViajePorId(@PathVariable Integer id) throws Exception{
        return viajeService.buscarViaje(id);
    }

    @RequestMapping(path="/{viajeId}/listaPasajeros")
    public List<Usuario> listarPasajerosRegistrados(@PathVariable Integer viajeId) throws Exception{
        return viajeService.listarPasajerosDelViaje(viajeId);

    }


    @RequestMapping(path="/{viajeId}/solicitudesPendientes")
    public List<Solicitud> listarSolicitudesPendientesDelViaje(@PathVariable Integer viajeId) throws Exception{
        return viajeService.listarSolicitudesPendientesDelViaje(viajeId);
    }

    @RequestMapping(path="/solicitudesConfirmadas/{viajeId}", method=RequestMethod.GET)
    public List<Solicitud> listarSolicitudesConfirmadasDelViaje(@PathVariable("viajeId") Integer viajeId) throws Exception{
        return viajeService.listarSolicitudesConfirmadasDelViaje(viajeId);
    }

    

    @RequestMapping(path="update/{id}", method = RequestMethod.PUT)
    public int actualizarViaje(@RequestBody String estado, @PathVariable("id") Integer id) throws Exception{
        return viajeService.actualizarEstado(estado, id);
    }

    @RequestMapping(path="/{id}/{solicitudId}", method = RequestMethod.GET)
    public List<Viaje> listarViajePorSolicitudYPasajero(@PathVariable("solicitudId")int solicitudId, @PathVariable("id") int pasajeroId)throws Exception{
        return viajeService.listarPorSolicitudyPorPasajero(solicitudId, pasajeroId);
    }



}