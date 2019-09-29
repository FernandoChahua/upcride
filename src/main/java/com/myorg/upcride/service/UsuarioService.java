package com.myorg.upcride.service;

import com.myorg.upcride.model.Solicitud;
import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.model.Viaje;

import java.util.List;

public interface UsuarioService{

    Usuario registrarUsuario(Usuario u) throws Exception;
    List<Usuario> visualizarUsuariosRegistrados() throws Exception;
    Integer iniciarSesion(String correoUPC, String contraseña) throws Exception;
    Usuario obtenerPerfil(Integer id);
}
