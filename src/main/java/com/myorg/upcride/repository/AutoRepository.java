package com.myorg.upcride.repository;

import com.myorg.upcride.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Integer> {
  @Query("SELECT a FROM Auto a where a.conductor.id = ?1")
  Auto buscarAutoPorConductor(Integer idConductor);


}
