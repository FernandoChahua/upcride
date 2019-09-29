package com.myorg.upcride.controller;



import com.myorg.upcride.model.Auto;
import com.myorg.upcride.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autos")
public class AutoController {

    private AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService){
        this.autoService = autoService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Auto guardarAuto(@RequestBody Auto a) throws Exception{
        return autoService.guardarAuto(a);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Auto buscarAutoPorConductor(Integer conductorId) throws Exception{
        return autoService.buscarAutoPorConductor(conductorId);
    }

}



