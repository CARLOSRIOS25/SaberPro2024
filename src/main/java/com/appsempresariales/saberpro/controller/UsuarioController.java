package com.appsempresariales.saberpro.controller;

import com.appsempresariales.saberpro.model.Usuario;
import com.appsempresariales.saberpro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String usuario(){
        return "usuarios";
    }

    @PostMapping("/agregar")
    public String registrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/coordinadores";
    }

    @GetMapping("/all")
    public String obtenerUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        //usamos stream para filtrar el usuario con id 1 y luego lo convertimos en una lista
        if (usuarios != null) {
            usuarios = usuarios.stream().filter(usuario -> usuario.getId() != "1")
                    .collect(Collectors.toList());
        }
        model.addAttribute("users", usuarios);
        return "listarUsuarios";
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
    }
}
