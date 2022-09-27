package com.example.demoapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoapi.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
