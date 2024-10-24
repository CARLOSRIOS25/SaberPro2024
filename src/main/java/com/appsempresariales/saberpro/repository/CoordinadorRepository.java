package com.appsempresariales.saberpro.repository;

import com.appsempresariales.saberpro.model.Coordinador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinadorRepository extends MongoRepository<Coordinador, String> {
}
