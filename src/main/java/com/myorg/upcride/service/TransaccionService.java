package com.myorg.upcride.service;

import com.myorg.upcride.model.Transaccion;

public interface TransaccionService {
    Transaccion registrarTransaccion(Transaccion t) throws Exception;
    Transaccion visualizarTransaccionesPorViaje(Integer viajeId) throws Exception;
}
