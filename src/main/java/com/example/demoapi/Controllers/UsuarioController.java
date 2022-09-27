package com.example.demoapi.Controllers;

import com.example.demoapi.UsuarioRepository;
import com.example.demoapi.Models.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioRepository Repo;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return Repo.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return Repo.findById(id).get();
    }


    @PostMapping("/usuarios")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return Repo.save(usuario);
    }

    @PutMapping("/usuarios")
    public void editUsuario(@RequestBody Usuario usuario){
        if(usuario.getId() > 0)
            Repo.save(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id){
        Repo.deleteById(id);
    }

}
