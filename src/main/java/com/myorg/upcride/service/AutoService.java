package com.myorg.upcride.service;

import com.myorg.upcride.model.Auto;

public interface AutoService {

    Auto guardarAuto(Auto auto) throws Exception;
    Auto buscarAutoPorConductor(Integer conductorId) throws Exception;
    
}
