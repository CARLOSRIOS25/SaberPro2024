package com.appsempresariales.saberpro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "coordinadores")
public class Coordinador {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    @DBRef
    private Usuario usuario;
}
