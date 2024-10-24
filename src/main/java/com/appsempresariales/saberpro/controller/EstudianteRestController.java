package com.appsempresariales.saberpro.controller;

import com.appsempresariales.saberpro.errors.NotFoundException;
import com.appsempresariales.saberpro.model.Estudiante;
import com.appsempresariales.saberpro.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteRepository estudianteRepository;


    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody @Valid Estudiante estudiante, UriComponentsBuilder uriComponentsBuilder) {
        Estudiante e = estudianteRepository.save(estudiante);
        URI url = uriComponentsBuilder.path("/api/estudiantes/{id}").buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(url).body(e);
    }

    @GetMapping
    public ResponseEntity<Page<Estudiante>> listarEstudiantes(Pageable paginacion) {
        return ResponseEntity.ok(estudianteRepository.findAll(paginacion)
                .map(estudiante -> new Estudiante(estudiante.getId(), estudiante.getTipoDocumento(), estudiante.getNumDocumento(),
        estudiante.getApellido(), estudiante.getNombre(), estudiante.getEmail(), estudiante.getNumTelefono(),
        estudiante.getNumRegistro(), estudiante.getPuntaje(), estudiante.getPuntajeNivel(), estudiante.getComunicacionEscrita(),
        estudiante.getComunicacionEscritaNivel(), estudiante.getRzmtCuantitativo(), estudiante.getRzmtCuantitativoNivel(),
        estudiante.getLecturaCritica(), estudiante.getLecturaCriticaNivel(), estudiante.getCompetenciasCiudadanas(),
        estudiante.getCompetenciasCiudadanasNivel(), estudiante.getIngles(), estudiante.getInglesNivel(),
        estudiante.getProyectosIngenieria(), estudiante.getProyectosIngenieriaNivel(), estudiante.getPensamientoMatematico(),
        estudiante.getPensamientoMatematicoNivel(), estudiante.getDiseñoSoftware(), estudiante.getDiseñoSoftwareNivel(),
        estudiante.getNivelIngles())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable String id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudiante) {
        return estudianteRepository.findById(id)
                .map(existingEstudiante -> {
                    estudiante.setId(id);
                    Estudiante updatedEstudiante = estudianteRepository.save(estudiante);
                    return ResponseEntity.ok().body(updatedEstudiante);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable String id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        estudianteRepository.delete(estudiante);
        return ResponseEntity.ok(estudiante);
    }
}
