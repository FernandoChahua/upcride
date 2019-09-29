package com.myorg.upcride.repository;

import com.myorg.upcride.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

    @Query("SELECT t FROM Transaccion t WHERE t.viaje.id = ?1")
    Transaccion visualizarTransaccionesPorViaje(Integer viajeId) throws Exception;

}
