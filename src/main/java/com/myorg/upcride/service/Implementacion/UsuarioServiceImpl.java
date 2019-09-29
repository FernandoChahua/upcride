package com.myorg.upcride.service.Implementacion;

import com.myorg.upcride.model.Usuario;
import com.myorg.upcride.repository.UsuarioRepository;
import com.myorg.upcride.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario registrarUsuario(Usuario u){
        List<Usuario> lista = usuarioRepository.findAll();
       int c = 0;
        try{
            for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCodigo()== u.getCodigo() ||
             (lista.get(i).getNombres().equals( u.getNombres()) &&
             lista.get(i).getApellidos().equals( u.getApellidos())) ){
                c = 1;
            }

        }
        if(u.getRol() == 'C') {

        }
       }catch(Exception ex){
           if(c == 1){
            throw ex;
       }
        }

        return usuarioRepository.save(u);
    }

    @Override
    public List<Usuario> visualizarUsuariosRegistrados() throws Exception {
        return usuarioRepository.findAll();
    }

    @Override
    public Integer iniciarSesion(String correoUPC, String contraseña) throws Exception{
        return usuarioRepository.iniciarSesion(correoUPC, contraseña);
    }
}
