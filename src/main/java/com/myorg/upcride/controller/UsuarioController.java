package com.myorg.upcride.controller;



import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(path="/pasajero", method = RequestMethod.POST)
    public Usuario registrarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuario.setRol('P');
       return usuarioService.registrarUsuario(usuario);
    }

    @RequestMapping(path="/conductor", method = RequestMethod.POST)
    public Usuario registrarConductor(@RequestBody Usuario conductor) throws Exception{
           conductor.setRol('C');
           return usuarioService.registrarUsuario(conductor);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Usuario verPerfil(@PathVariable Integer id) throws Exception{
        return usuarioService.obtenerPerfil(id);
    }


    @RequestMapping(path="/inicioSesion/{correo}/{contraseña}", method=RequestMethod.GET)
    public Integer iniciarSesion(@PathVariable("correo") String correoUPC, @PathVariable("contraseña") String contraseña) throws Exception{
             return usuarioService.iniciarSesion(correoUPC, contraseña);
    }




}
