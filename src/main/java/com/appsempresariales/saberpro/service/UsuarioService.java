package com.appsempresariales.saberpro.service;

import com.appsempresariales.saberpro.model.Usuario;
import com.appsempresariales.saberpro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario authenticateUser(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }
}
