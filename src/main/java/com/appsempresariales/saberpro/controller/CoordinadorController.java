package com.appsempresariales.saberpro.controller;

import com.appsempresariales.saberpro.model.Estudiante;
import com.appsempresariales.saberpro.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/coordinadores")
public class CoordinadorController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public String estudiantesEstadisticas(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        DoubleSummaryStatistics estadisticas = estudiantes.stream()
                .filter(e -> !"ANULADO".equals(e.getPuntaje()) && Double.parseDouble(e.getPuntaje()) > 0) //filtramos los puntajes anulados y los que no son números
                .collect(Collectors.summarizingDouble(e -> Double.parseDouble(e.getPuntaje())));

        double maxPuntaje = estadisticas.getMax();
        double minPuntaje = estadisticas.getMin();
        long countPuntajes = estadisticas.getCount();
        double puntajeProm = estadisticas.getAverage();

        model.addAttribute("maxPuntaje", maxPuntaje);
        model.addAttribute("minPuntaje", minPuntaje);
        model.addAttribute("puntajeProm", puntajeProm);
        model.addAttribute("countPuntajes", countPuntajes);
        return "coordinadores";
    }
}
