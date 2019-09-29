package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Transaccion;
import com.myorg.upcride.repository.TransaccionRepository;
import com.myorg.upcride.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransaccionServiceImpl implements TransaccionService {


    private TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionServiceImpl(TransaccionRepository transaccionRepository){
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public Transaccion registrarTransaccion(Transaccion t) throws Exception {
        return transaccionRepository.save(t);
    }

    @Override
    public Transaccion visualizarTransaccionesPorViaje(Integer viajeId) throws Exception {
        return transaccionRepository.visualizarTransaccionesPorViaje(viajeId);
    }
}
