package com.portfolio.CEN.Controller;

import com.portfolio.CEN.Entity.Usuario;
import com.portfolio.CEN.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @GetMapping ("/id/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario updateUsuario = usuarioService.editarUsuario(usuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }

   // @PutMapping("/edit/{id}")
   // public ResponseEntity editarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuarioDescripcion) {
   //     return ResponseEntity.ok().body(usuarioService.putUsuario(id, usuarioDescripcion.getDescripcion()));

}

