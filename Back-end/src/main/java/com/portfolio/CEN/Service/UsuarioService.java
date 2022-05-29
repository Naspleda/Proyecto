package com.portfolio.CEN.Service;

import com.portfolio.CEN.Entity.Usuario;
import com.portfolio.CEN.Exception.UserNotFoundException;
import com.portfolio.CEN.Repository.UsuarioRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional


public class UsuarioService {
    @Autowired
    private final UsuarioRepo usuarioRepo;

    public Usuario getUsuario(){
        List<Usuario> usuarioList = usuarioRepo.findAll();
        return usuarioList.get(0);
    }

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
     public Usuario agregarUsuario(Usuario usuario ){
        return usuarioRepo.save(usuario);
    }
    public List<Usuario> buscarUsuario(){
        return usuarioRepo.findAll();
    }
    
    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    
    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
    }

    public Usuario putUsuario(Long id, String info) {
        Optional<Usuario> usuarioInfo = usuarioRepo.findById(id);
        if (usuarioInfo.isPresent()){
            Usuario usuario = usuarioInfo.get();
            usuario.setDescripcion(info);
            return usuarioRepo.save(usuario);
        }
        return null;
    }
}
