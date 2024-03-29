package com.myorg.upcride.repository;

import com.myorg.upcride.model.Usuario;

import com.myorg.upcride.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    @Query("SELECT u.id FROM Usuario u WHERE u.correoUPC = :correo AND u.contraseņa = :contraseņa")
    Integer iniciarSesion(@Param("correo") String correoUPC, @Param("contraseņa") String contraseņa);
}
