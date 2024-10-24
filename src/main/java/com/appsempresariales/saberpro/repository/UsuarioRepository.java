package com.appsempresariales.saberpro.repository;

import com.appsempresariales.saberpro.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByUsernameAndPassword(String username, String password);
}
