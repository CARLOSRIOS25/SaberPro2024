package com.appsempresariales.saberpro.repository;

import com.appsempresariales.saberpro.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

        Estudiante findByNumDocumento(Long numDocumento);
}
