package com.myorg.upcride.repository;

import com.myorg.upcride.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    @Query("SELECT s FROM Solicitud s JOIN Viaje v ON s.viaje.id = v.id JOIN Usuario u ON v.conductor.id = u.id WHERE u.id = ?1")
    List<Solicitud> listarSolicitudesPorConductor(Integer conductorId) throws Exception;

    @Modifying
    @Query("UPDATE Solicitud s SET s.confirmacionConductor = :confirmacion WHERE s.id = :id")
    @Transactional
    int actualizarConfirmacionConductor(@Param("confirmacion") String confirmacionConductor, @Param("id") Integer solicitudId) throws Exception;
}