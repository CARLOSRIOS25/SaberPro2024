package com.appsempresariales.saberpro.controller;

import com.appsempresariales.saberpro.model.Estudiante;
import com.appsempresariales.saberpro.repository.EstudianteRepository;
import com.appsempresariales.saberpro.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/estudiantePorDocumento")
    public String estudiantePorDocumento(@RequestParam long numDocumento, Model model) {
        Estudiante estudiante = estudianteRepository.findByNumDocumento(numDocumento);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
        }
        return "estudiantePorDocumento";
    }

    @GetMapping("/listar")
    public String listarEstudiantesAdmin(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantesAdmin";
    }

    @GetMapping("/all")
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "listaEstudiantes";
    }

    @GetMapping("/listarPorPuntaje")
    public String listarPorPuntaje(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<Estudiante> estudiantesOrdenados = estudiantes.stream()
                .sorted(Comparator.comparing(Estudiante::getPuntaje).reversed())
                .filter(e -> !"ANULADO".equals(e.getPuntaje()))
                .collect(Collectors.toList());
        model.addAttribute("estudiantes", estudiantesOrdenados);
        return "listarPorPuntaje";
    }

    @GetMapping("/listarPorPuntajeAdmin")
    public String listarPorPuntajeAdmin(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<Estudiante> estudiantesOrdenados = estudiantes.stream()
                .sorted(Comparator.comparing(Estudiante::getPuntaje).reversed())
                .filter(e -> !"ANULADO".equals(e.getPuntaje()))
                .collect(Collectors.toList());
        model.addAttribute("estudiantes", estudiantesOrdenados);
        return "listarPorPuntajeAdmin";
    }

    @GetMapping("/formEstudiante")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formEstudiante";
    }

    @PostMapping("/agregar")
    public String registrarEstudiante(@RequestParam String tipoDocumento,
                                      @RequestParam long numDocumento,
                                      @RequestParam String apellido,
                                      @RequestParam String nombre,
                                      @RequestParam String email,
                                      @RequestParam long numTelefono,
                                      @RequestParam String numRegistro,
                                      @RequestParam String puntaje,
                                      @RequestParam Integer comunicacionEscrita,
                                      @RequestParam Integer rzmtCuantitativo,
                                      @RequestParam Integer lecturaCritica,
                                      @RequestParam Integer competenciasCiudadanas,
                                      @RequestParam Integer ingles,
                                      @RequestParam Integer proyectosIngenieria,
                                      @RequestParam Integer pensamientoMatematico,
                                      @RequestParam Integer diseñoSoftware) {
        estudianteService.registrarEstudiante(tipoDocumento, numDocumento, apellido, nombre, email, numTelefono,
                numRegistro, puntaje, comunicacionEscrita, rzmtCuantitativo, lecturaCritica, competenciasCiudadanas,
                ingles, proyectosIngenieria, pensamientoMatematico, diseñoSoftware);
        return "formEstudiante";
    }

    @GetMapping("/editar/{id}")
    public String modificarAsociacion(@PathVariable("id") String id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "formEstudiante";
        } else {
            return "redirect:/estudiantes/listar";
        }
    }


}
