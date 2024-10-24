package com.appsempresariales.saberpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AterrizajeController {

    @GetMapping("/")
    public String aterrizaje() {
        return "login";
    }
}
