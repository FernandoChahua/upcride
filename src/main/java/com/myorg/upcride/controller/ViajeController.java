package com.myorg.upcride.controller;


import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;
import com.myorg.upcride.service.SolicitudService;
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
    private SolicitudService solicitudService;

    @Autowired
    public ViajeController(ViajeService viajeService, SolicitudService solicitudService){
        this.viajeService = viajeService;
        this.solicitudService = solicitudService;
    }


    @GetMapping(path="/conductor/{conductorId}")
    public List<Viaje> listarViajesPorConductor(@PathVariable Integer conductorId) throws Exception{
      return viajeService.listarViajesPorConductor(conductorId);
    }
    @PostMapping( path="/publicar/{conductorId}")
    public Viaje publicarViaje(@RequestBody Viaje v, @PathVariable Integer conductorId) throws Exception {

        return viajeService.publicarViaje(v, conductorId);
    }

    @GetMapping(path="/{id}")
    public Viaje buscarViajePorId(@PathVariable Integer id) throws Exception{
        return viajeService.buscarViaje(id);
    }


    @RequestMapping(path="/conductor/{conductorId}", method= RequestMethod.GET)
    public List<Solicitud> listarSolicitudesPorConductor(@PathVariable Integer conductorId) throws Exception{
          return solicitudService.listarSolicitudesPorConductor(conductorId);
    }

    @RequestMapping(path="update/{id}", method = RequestMethod.PUT)
    public int actualizarViaje(@RequestBody String estado, @PathVariable("id") Integer id) throws Exception{
        return viajeService.actualizarEstado(estado, id);
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public Solicitud solicitarViaje(@RequestBody Solicitud solicitud) throws Exception {

        return solicitudService.guardarSolicitud(solicitud);
    }


    @RequestMapping(path="update/{solicitudId}", method = RequestMethod.PUT)
    public int actualizarConfirmacionConductor(@RequestBody String confirmacionConductor, @PathVariable("solicitudId") Integer solicitudId) throws Exception{
        return solicitudService.actualizarConfirmacionConductor(confirmacionConductor, solicitudId);
    }

}
