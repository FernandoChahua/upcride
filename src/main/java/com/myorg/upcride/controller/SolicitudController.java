package com.myorg.upcride.controller;



import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
/*
    private SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService){
        this.solicitudService = solicitudService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Solicitud registrarUsuario(@RequestBody Solicitud solicitud) throws Exception {

        return solicitudService.guardarSolicitud(solicitud);
    }


    @RequestMapping(path="/conductor/{conductorId}", method= RequestMethod.GET)
    public List<Solicitud> listarSolicitudesPorConductor(@PathVariable Integer conductorId) throws Exception{
          return solicitudService.listarSolicitudesPorConductor(conductorId);
    }

    @RequestMapping
    public List<Solicitud> listarSolicitudes() throws Exception
    {
        return solicitudService.listarSolicitudes();
    }

    @RequestMapping(path="update/{solicitudId}", method = RequestMethod.PUT)
    public int actualizarConfirmacionConductor(@RequestBody String confirmacionConductor, @PathVariable("solicitudId") Integer solicitudId) throws Exception{
        return solicitudService.actualizarConfirmacionConductor(confirmacionConductor, solicitudId);
    }
*/


}