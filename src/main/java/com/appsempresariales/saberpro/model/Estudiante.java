package com.appsempresariales.saberpro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private String tipoDocumento;
    private long numDocumento;
    private String apellido;
    private String nombre;
    private String email;
    private long numTelefono;
    private String numRegistro;
    private String puntaje;
    private String puntajeNivel;
    private Integer comunicacionEscrita;
    private String comunicacionEscritaNivel;
    private Integer rzmtCuantitativo;
    private String rzmtCuantitativoNivel;
    private Integer lecturaCritica;
    private String lecturaCriticaNivel;
    private Integer competenciasCiudadanas;
    private String competenciasCiudadanasNivel;
    private Integer ingles;
    private String inglesNivel;
    private Integer proyectosIngenieria;
    private String proyectosIngenieriaNivel;
    private Integer pensamientoMatematico;
    private String pensamientoMatematicoNivel;
    private Integer diseñoSoftware;
    private String diseñoSoftwareNivel;
    private String nivelIngles;
}
