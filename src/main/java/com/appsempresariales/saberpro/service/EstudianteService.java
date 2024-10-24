package com.appsempresariales.saberpro.service;

import com.appsempresariales.saberpro.model.Estudiante;
import com.appsempresariales.saberpro.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante registrarEstudiante(String tipoDocumento, long numDocumento, String apellido, String nombre,
                                          String email, long numTelefono, String numRegistro, String puntaje, Integer comunicacionEscrita,
                                          Integer rzmtCuantitativo, Integer lecturaCritica, Integer competenciasCiudadanas, Integer ingles,
                                          Integer proyectosIngenieria, Integer pensamientoMatematico, Integer diseñoSoftware) {

        Estudiante estudiante = new Estudiante();
        estudiante.setTipoDocumento(tipoDocumento);
        estudiante.setNumDocumento(numDocumento);
        estudiante.setApellido(apellido);
        estudiante.setNombre(nombre);
        estudiante.setEmail(email);
        estudiante.setNumTelefono(numTelefono);
        estudiante.setNumRegistro(numRegistro);
        estudiante.setPuntaje(puntaje);
        estudiante.setPuntajeNivel(asignarNivelPuntaje(puntaje));
        estudiante.setComunicacionEscrita(comunicacionEscrita);
        estudiante.setComunicacionEscritaNivel(asignarNivel(comunicacionEscrita));
        estudiante.setRzmtCuantitativo(rzmtCuantitativo);
        estudiante.setRzmtCuantitativoNivel(asignarNivel(rzmtCuantitativo));
        estudiante.setLecturaCritica(lecturaCritica);
        estudiante.setLecturaCriticaNivel(asignarNivel(lecturaCritica));
        estudiante.setCompetenciasCiudadanas(competenciasCiudadanas);
        estudiante.setCompetenciasCiudadanasNivel(asignarNivel(competenciasCiudadanas));
        estudiante.setIngles(ingles);
        estudiante.setInglesNivel(asignarNivel(ingles));
        estudiante.setProyectosIngenieria(proyectosIngenieria);
        estudiante.setProyectosIngenieriaNivel(asignarNivel(proyectosIngenieria));
        estudiante.setPensamientoMatematico(pensamientoMatematico);
        estudiante.setPensamientoMatematicoNivel(asignarNivel(pensamientoMatematico));
        estudiante.setDiseñoSoftware(diseñoSoftware);
        estudiante.setDiseñoSoftwareNivel(asignarNivel(diseñoSoftware));
        estudiante.setNivelIngles(asignarNivelIngles(ingles));

        return estudianteRepository.save(estudiante);
    }

    private String asignarNivelPuntaje(String puntaje) {
        int puntajeInt;
        try {
            puntajeInt = Integer.parseInt(puntaje);
        } catch (NumberFormatException e) {
            if ("ANULADO".equals(puntaje)) {
                return "nivel 1";
            } else {
                return "nivel 1";
            }
        }

        if (0 <= puntajeInt && puntajeInt <= 125) {
            return "nivel 1";
        } else if (126 <= puntajeInt && puntajeInt <= 155) {
            return "nivel 2";
        } else if (156 <= puntajeInt && puntajeInt <= 190) {
            return "nivel 3";
        } else if (191 <= puntajeInt && puntajeInt <= 300) {
            return "nivel 4";
        } else {
            return "nivel 1";
        }
    }

    private String asignarNivelIngles(Integer ingles) {
        if (125 <= ingles && ingles <= 145) {
            return "A1";
        } else if (146 <= ingles && ingles <= 180) {
            return "A2";
        } else if (181 <= ingles && ingles <= 200) {
            return "B1";
        } else if (201 <= ingles && ingles <= 300) {
            return "B2";
        } else {
            return "A0";
        }
    }

    private String asignarNivel(Integer puntos) {
        if (126 <= puntos && puntos <= 155) {
            return "nivel 2";
        } else if (156 <= puntos && puntos <= 190) {
            return "nivel 3";
        } else if (191 <= puntos && puntos <= 300) {
            return "nivel 4";
        } else {
            return "nivel 1";
        }
    }
}
