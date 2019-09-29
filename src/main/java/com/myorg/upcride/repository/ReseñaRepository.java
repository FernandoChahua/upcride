package com.myorg.upcride.repository;

import com.myorg.upcride.model.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Integer> {
    @Query("SELECT r FROM Reseña r JOIN Viaje v ON r.viaje.id = v.id JOIN Usuario u ON v.conductor.id = u.id WHERE u.id = ?1")
    List<Reseña> listarReseñasPorConductor (Integer conductorId);

}
