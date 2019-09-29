package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Auto;
import com.myorg.upcride.repository.AutoRepository;
import com.myorg.upcride.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutoServiceImpl implements AutoService {

    AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    @Override
    public Auto guardarAuto(Auto auto) throws Exception{
        return autoRepository.save(auto);
    }

    @Override
    public Auto buscarAutoPorConductor(Integer conductorId) throws Exception{
        return autoRepository.buscarAutoPorConductor(conductorId);
    }

}
