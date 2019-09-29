package com.myorg.upcride.controller;



import com.myorg.upcride.model.Itinerario;
import com.myorg.upcride.service.ItinerarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/itinerarios")
public class ItinerarioController {

    private ItinerarioService itinerarioService;

    @Autowired
    public ItinerarioController(ItinerarioService itinerarioService){
        this.itinerarioService = itinerarioService;
    }


   /*@RequestMapping(method = RequestMethod.POST)
    public guardarItinerario(@RequestBody Itinerario i){

    }*/

}
