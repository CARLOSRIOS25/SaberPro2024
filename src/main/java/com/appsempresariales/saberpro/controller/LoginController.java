package com.appsempresariales.saberpro.controller;

import com.appsempresariales.saberpro.model.Usuario;
import com.appsempresariales.saberpro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm(){
        //nombre vista a retornar
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Usuario usuario = usuarioService.authenticateUser(username, password);

        if (usuario != null){
            if (usuario.getId().equals("1")){
                return "redirect:/coordinadores";
            } else {
                return "redirect:/usuarios";
            }

        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
