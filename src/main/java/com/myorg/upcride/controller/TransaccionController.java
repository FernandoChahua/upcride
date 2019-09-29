package com.myorg.upcride.controller;


import com.myorg.upcride.model.Transaccion;
import com.myorg.upcride.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaccion")
public class TransaccionController {

   /* private TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService){
        this.transaccionService = transaccionService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Transaccion registrarTransaccion(@RequestBody Transaccion t) throws Exception {
        return transaccionService.registrarTransaccion(t);
    }

    @RequestMapping(path = "/transacciones")
    public Transaccion visualizarTransaccionesPorViaje(@RequestParam(value = "viajeId" , required = true) Integer viajeId) throws Exception {
        return transaccionService.visualizarTransaccionesPorViaje(viajeId);
    }*/
}
