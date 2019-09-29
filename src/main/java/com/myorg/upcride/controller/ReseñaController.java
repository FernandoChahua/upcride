
package com.myorg.upcride.controller;
import com.myorg.upcride.model.Reseña;
import com.myorg.upcride.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/reseñas")
public class ReseñaController {

    private ReseñaService reseñaService;

    @Autowired
    public ReseñaController(ReseñaService reseñaService){
        this.reseñaService = reseñaService;
    }


    @RequestMapping
    public Reseña publicarReseñas(Reseña r) throws Exception {
        return reseñaService.publicarReseña(r);
    }
    @RequestMapping(path="/{viajeId}", method = RequestMethod.POST)
    public Reseña publicarReseñaPorViaje(@RequestBody Reseña r, @PathVariable Integer viajeId) throws Exception{
        return reseñaService.publicarReseñaPorViaje(r,viajeId);
    }

    @RequestMapping(path="/{conductorId}", method = RequestMethod.GET)
    public List<Reseña> listarResñasPorConductor(@PathVariable Integer conductorId) throws Exception{
        return reseñaService.listarReseñasPorConductor(conductorId);
    }

}